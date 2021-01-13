package com.navi.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ArrayUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RpcServer Class
 *
 * @author ganxf
 * @date 2020/9/17
 */
@Slf4j
public class RpcServer {

    private Map<String, Object> registyMap = new HashMap<>();
    private List<String> serviceNames = new ArrayList<>();

    public void doPublish(String... packageNames) throws InterruptedException {
        findServices(packageNames);
        doRegister();

        // 创建nio事件处理loopgroup
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();

        try {
            // 创建bootstrap
            ServerBootstrap bootstrap = new ServerBootstrap();
            // 绑定looggroup
            bootstrap.group(boss, work)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new ObjectEncoder());
                            pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                            pipeline.addLast(new RpcServerHandler(registyMap));
                        }
                    });

            ChannelFuture sync = bootstrap.bind(8888).sync();
            sync.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }


    }

    private void findServices(String... packageNames) {
        if (ArrayUtil.isEmpty(packageNames)) {
            log.warn("传入的包名为空");
            return;
        }

        ClassLoader classLoader = this.getClass().getClassLoader();

        for (int i = 0; i < packageNames.length; i++) {
            String packageName = packageNames[i];
            URL resource = classLoader.getResource(packageName.replaceAll("\\.", "/"));
            File file = new File(resource.getFile());
            // 遍历包名下的文件
            for (File child : file.listFiles()) {
                String childName = child.getName();

                if (child.isDirectory()) {
                    findServices(packageName + "." + childName);
                    continue;
                }
                // 判断是否是class文件
                if (childName.endsWith(".class")) {
                    //去掉.class加入serviceNames中
                    String clazzName = childName.replace(".class", "").trim();
                    String serviceName = packageName + "." + clazzName;
                    log.info("扫描到服务：{}", serviceName);
                    serviceNames.add(serviceName);
                }
            }
        }
    }

    private void doRegister() {
        if (CollectionUtil.isEmpty(serviceNames)) {
            log.warn("没有找到要发布的服务");
            return;
        }

        for (String serviceName : serviceNames) {
            Class<?> clazz = null;
            try {
                clazz = Class.forName(serviceName);

                // 按照接口名称发布服务
                String interfaceName = clazz.getInterfaces()[0].getName();
                registyMap.put(interfaceName, clazz.newInstance());
            } catch (Exception e) {
                log.error("没有找到服务：{}", serviceName, e);
            }

        }


    }
}

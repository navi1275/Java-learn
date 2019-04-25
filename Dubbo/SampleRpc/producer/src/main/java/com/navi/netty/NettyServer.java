package com.navi.netty;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.navi.metadata.RpcService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * NettyServer Class
 *
 * @author navi
 * @date 2019-04-03
 * @since 1.0.0
 */
@Slf4j
@Component
public class NettyServer implements InitializingBean, ApplicationContextAware {

    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(4);
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(1);

    private Map<String, Object> serviceMap = new HashMap<>();

    @Value("${config.rpc.server.address}")
    private String serverAddress;

    @Autowired
    private ServiceRegistry serviceRegistry;

    @Override
    public void afterPropertiesSet() throws Exception {

        start();
    }

    private void start() {
        final NettyServerHandler handler = new NettyServerHandler(serviceMap);

        ThreadFactoryBuilder threadFactoryBuilder = new ThreadFactoryBuilder();
        ThreadFactory threadFactory = threadFactoryBuilder.setNameFormat("demo-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(1, 1,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), threadFactory);
        executorService.execute(() -> {
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(bossGroup,workerGroup).
                        channel(NioServerSocketChannel.class).
                        option(ChannelOption.SO_BACKLOG,1024).
                        childOption(ChannelOption.SO_KEEPALIVE,true).
                        childOption(ChannelOption.TCP_NODELAY,true).
                        childHandler(new ChannelInitializer<SocketChannel>() {
                            //创建NIOSocketChannel成功后，在进行初始化时，将它的ChannelHandler设置到ChannelPipeline中，用于处理网络IO事件
                            protected void initChannel(SocketChannel channel) throws Exception {
                                ChannelPipeline pipeline = channel.pipeline();
                                pipeline.addLast(new IdleStateHandler(0, 0, 60));
                                pipeline.addLast(new JsonEncoder());
                                pipeline.addLast(new JsonDecoder());
                                pipeline.addLast(handler);
                            }
                        });
                String[] array = serverAddress.split(":");
                String host = array[0];
                int port = Integer.parseInt(array[1]);
                ChannelFuture cf = bootstrap.bind(host,port).sync();
                log.info("RPC 服务器启动.监听端口:{}", port);
                serviceRegistry.register(serverAddress);
                //等待服务端监听端口关闭
                cf.channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(RpcService.class);
        for(Object obj: beans.values()){
            Class<?> clazz = obj.getClass();
            Class<?>[] interfaces = clazz.getInterfaces();
            for (Class<?> clz : interfaces){
                String name = clz.getName();
                log.info("加载服务类：{}", name);
                serviceMap.put("name", obj);
            }

        }
        log.info("已加载全部服务接口：{}", serviceMap);
    }
}

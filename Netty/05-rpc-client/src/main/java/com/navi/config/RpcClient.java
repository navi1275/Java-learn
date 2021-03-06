package com.navi.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * RpcClient Class
 *
 * @author ganxf
 * @date 2020/9/17
 */
@Slf4j
public class RpcClient {

    public static <T> T create(Class<T> clazz) {
        // 动态代理
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                final RpcClientHandler handler = new RpcClientHandler();
                // 创建NioEventLoopGroup
                NioEventLoopGroup group = new NioEventLoopGroup();
                try {
                    // netty客户端使用Bootstrap
                    Bootstrap bootstrap = new Bootstrap();
                    // 1.绑定上面创建的group
                    bootstrap.group(group)
                            .channel(NioSocketChannel.class)
                            //ChannelOption.TCP_NODELAY 设置成true，禁用nagle算法，减少延迟
                            .option(ChannelOption.TCP_NODELAY, true)
                            .handler(new ChannelInitializer<SocketChannel>() {
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    ChannelPipeline pipeline = ch.pipeline();
                                    pipeline.addLast(new ObjectEncoder());
                                    pipeline.addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)));
                                    pipeline.addLast(handler);
                                }
                            });
                    // sync 使异步转同步
                    ChannelFuture future = bootstrap.connect("127.0.0.1", 8888).sync();
                    InvokeInfo invokeInfo = new InvokeInfo();
                    invokeInfo.setClazzName(clazz.getName());
                    invokeInfo.setMethodName(method.getName());
                    invokeInfo.setParamTypes(method.getParameterTypes());
                    invokeInfo.setParamValues(args);


                    future.channel().writeAndFlush(invokeInfo).sync();
                    future.channel().closeFuture().sync();

                }finally {
                    if(group!=null){
                        group.shutdownGracefully();
                    }
                }

                return handler.getResult();

            }
        });

    }
}

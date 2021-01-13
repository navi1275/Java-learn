package com.navi.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * NaviServer Class
 *
 * @author ganxf
 * @date 2020/6/22
 */
public class NaviServer {

    public static void main(String[] args) {
        // 用于处理客户端连接请求，将请求发送给workgroup处理的eventloop
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理连接请求的eventloop
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            // 启动ServerChannel
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workGroup);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>(){
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    ChannelPipeline pipeline = socketChannel.pipeline();
                    pipeline.addLast(new StringDecoder());
                    pipeline.addLast(new StringEncoder());
                    pipeline.addLast(new NaviChannelHandler());
                }
            });
            // 指定监听端口号
            ChannelFuture future = bootstrap.bind(8888).sync();
            // 关闭ServerChannel
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 优雅关闭
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }







    }
}

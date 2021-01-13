package com.navi.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * NaviChannelInitializer Class
 *  管道初始化
 * @author ganxf
 * @date 2020/6/22
 */
public class NaviChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 获取管道
        ChannelPipeline pipeline = socketChannel.pipeline();
        // 加入HttpServerCodec处理器，解码器HttpRequestDecoder和编码器HttpResponseEncoder的结合体
        pipeline.addLast(new HttpServerCodec());
        // 自定义的请求处理器
        pipeline.addLast(new NaviChannelHandler());
    }
}

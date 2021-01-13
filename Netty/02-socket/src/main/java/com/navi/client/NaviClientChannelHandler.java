package com.navi.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

/**
 * NaviClientChannelHandler Class
 *
 * @author ganxf
 * @date 2020/6/22
 */
@Slf4j
public class NaviClientChannelHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        log.info("来自{}的消息，{}", ctx.channel().remoteAddress(), msg);
        ctx.writeAndFlush("I am client, hello, " + LocalDate.now().toString());
        TimeUnit.MILLISECONDS.sleep(500);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("I am client, hello, server");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

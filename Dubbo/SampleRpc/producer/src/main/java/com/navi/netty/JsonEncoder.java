package com.navi.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageCodec;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.List;

/**
 * JsonEncoder Class
 *
 * @author navi
 * @date 2019-04-03
 * @since 1.0.0
 */
public class JsonEncoder extends ByteToMessageCodec {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object o, ByteBuf byteBuf) throws Exception {

    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List list) throws Exception {

    }
}

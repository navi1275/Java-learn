package com.navi.config;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * RpcServerHandler Class
 *
 * @author ganxf
 * @date 2020/9/17
 */
@Slf4j
public class RpcServerHandler extends ChannelInboundHandlerAdapter {

    private Map<String, Object> registyMap;

    public RpcServerHandler(Map<String, Object> registyMap) {
        this.registyMap = registyMap;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if( msg instanceof  InvokeInfo){
            InvokeInfo info = (InvokeInfo) msg;
            log.info("接收到客户端信息，{}", info);
            String clazzName = info.getClazzName();
            String methodName = info.getMethodName();
            Class<?>[] paramTypes = info.getParamTypes();
            Object[] paramValues = info.getParamValues();

            Object provider = registyMap.get(clazzName);
            Method method = provider.getClass().getMethod(methodName, paramTypes);
            Object result = method.invoke(provider, paramValues);
            ctx.writeAndFlush(result);
            ctx.close();

        }else {
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("处理链接异常", cause);
        ctx.close();
    }
}

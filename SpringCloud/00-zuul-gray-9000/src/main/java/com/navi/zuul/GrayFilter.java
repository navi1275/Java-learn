package com.navi.zuul;

import cn.hutool.core.util.StrUtil;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.api.RibbonFilterContext;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * RouteFilter Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
@Slf4j
@Component
public class GrayFilter extends ZuulFilter {

    private static final AtomicBoolean flag = new AtomicBoolean(true);

    //pre前置，post后置，error错误 过滤器
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    //过滤顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // 过滤规则
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // 通过过滤器后处理
    @Override
    public Object run() throws ZuulException {
        log.info("通过RouteFilter过滤器");
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        //请求头加 gray-mark标识， 值为enable的请求负载到元数据host-mark为gray-host的服务上
        // String grayMark = request.getHeader("gray-mark");
        //
        // RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
        // if(StrUtil.equalsAny("enable", grayMark)){
        //     RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
        // }


        // 另一种算法，一半一半
        if(flag.get()){
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "running-host");
            flag.set(false);
        }else{
            RibbonFilterContextHolder.getCurrentContext().add("host-mark", "gray-host");
            flag.set(true);
        }
        return null;
    }
}

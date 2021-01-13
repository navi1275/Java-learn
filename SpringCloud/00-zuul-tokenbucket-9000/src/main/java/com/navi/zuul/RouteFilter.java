package com.navi.zuul;

import cn.hutool.core.util.StrUtil;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * RouteFilter Class
 *
 * @author navi
 * @date 2019-04-18
 * @since 1.0.0
 */
@Slf4j
@Component
public class RouteFilter extends ZuulFilter {

    //
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(2);

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
        RequestContext context = RequestContext.getCurrentContext();

        if(!RATE_LIMITER.tryAcquire()){
            log.warn("访问量超载");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
            return false;
        }
        return true;
    }

    // 通过过滤器后处理
    @Override
    public Object run() throws ZuulException {
        log.info("通过RouteFilter过滤器");
        return null;
    }
}

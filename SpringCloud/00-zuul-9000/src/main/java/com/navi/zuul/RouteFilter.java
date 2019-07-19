package com.navi.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
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
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String user = request.getParameter("user");
        if(user == null){
            log.warn("用户不存在");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(404);
            return null;
        }
        log.info("通过RouteFilter过滤器");
        return null;
    }
}

package com.navi.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * OneFilter Class
 *
 * @author ganxf
 * @date 2018/11/24
 */
@WebFilter(urlPatterns = "/*", filterName = "oneFilter")
public class OneFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("我是OneFilter，我被加载了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("请求路径被我过滤了");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}

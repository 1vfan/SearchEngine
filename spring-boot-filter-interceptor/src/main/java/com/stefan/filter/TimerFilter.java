package com.stefan.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2020/4/7 7:27 PM
 */
@WebFilter(filterName = "TimerFilter", urlPatterns = {"/*"})
public class TimerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("filter init ------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do Filter----------------------start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("do Filter----------------------end");
    }

    @Override
    public void destroy() {
        System.out.println("destroy -------------------");
    }
}

package com.yitsd.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName Demo01Filter
 * @Date 2022/6/29 17:27
 */
//@WebFilter("*.do")
public class Demo01Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("helloA");

        //放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("helloA2");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

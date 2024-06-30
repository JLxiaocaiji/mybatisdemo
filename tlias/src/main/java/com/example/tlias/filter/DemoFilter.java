package com.example.tlias.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")      // 1./* 表示拦截所有， 2./login: 拦截具体路径, 3./emps/*: 目录拦截
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Filter.super.init(filterConfig);
        System.out.println("init");
    }

    @Override
    public void destroy() {
//        Filter.super.destroy();
        System.out.println("destory");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 放行前的逻辑
        System.out.println("doFilter");

        // 放行后的逻辑

    }
}

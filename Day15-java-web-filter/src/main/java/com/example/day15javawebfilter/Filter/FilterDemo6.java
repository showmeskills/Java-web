package com.example.day15javawebfilter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo6 implements Filter {
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{}
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter demo6被执行了");
        chain.doFilter(req,resp);
        System.out.println("filter demo6 回来了");
    }
    @Override
    public void destroy(){}
}

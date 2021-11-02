package com.example.day15javawebfilter.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    /**
     * 在服务器启动后，会创建Filter对象，然后调用init方法。只执行一次。用于加载资源
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{
        System.out.println("init .... ");
    }
    /**
     * 每一次请求被拦截资源时，会执行。执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter 被执行");
        //放行
        chain.doFilter(req,resp);
        System.out.println("从index.jsp 返回来再次执行");
    }
    /**
     * 在服务器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执行一次。用于释放资源
     */
    @Override
    public void destroy(){
        System.out.println("destroy.....");
    }
}

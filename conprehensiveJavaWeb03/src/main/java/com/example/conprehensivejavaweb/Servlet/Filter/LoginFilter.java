package com.example.conprehensivejavaweb.Servlet.Filter;

import com.sun.codemodel.internal.fmt.JStaticJavaFile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//登录验证
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init (FilterConfig filterConfig) throws ServletException{}
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        //1.强制转换 ServletRequest to HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        //2.获取资源请求路径
        String uri = request.getRequestURI();
        //3.判断是否包含登录相关源路径,要注意排除css/js/图片验证码等资源
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/") || uri.contains("/checkCodeServlet") ){
            //包含，用户就是用户想登录,放行
            chain.doFilter(req,resp);
        }else{
            //不包含,需要验证用户是否登录
            //3.从获取session中获取user
            Object user = request.getSession().getAttribute("loginUser");
            if(user != null){
                //登录了，放行
                chain.doFilter(req,resp);
            }else{
                //没有登录转条登录页面
                request.setAttribute("login_msg","您尚未登录,请登录");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }
    @Override
    public void destroy(){}
}

package com.example.javawebday09;

import javax.servlet.*;
import java.io.IOException;
//单例对象;会存在线程安全问题
//不要该类定义成员变量
public class ServletDemo1 implements Servlet {
    //初始化方法
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("当服务器开启时,会执行初始化方法,只会执行一次");
    }
    //获取getServletConfig Servlet 配置对象
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
    //提供服务的方法;可以写逻辑代码;需要在web.xml中配置
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello world");
    }
    //获取Servlet的一些信息 版本,作者
    @Override
    public String getServletInfo() {
        return null;
    }
    //销毁生命周期 (释放资源)
    @Override
    public void destroy() {
        System.out.println("当服务器,关闭之前，执行当前函数(只有正常关闭的时候执行)，只执行一次");
    }
}

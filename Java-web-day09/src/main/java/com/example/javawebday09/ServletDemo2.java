package com.example.javawebday09;

import javax.jws.WebService;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//可以替换 web.xml
@WebServlet(name = "ServletDemo", value = "/servletDemo")
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {}

    @Override
    public ServletConfig getServletConfig() {return null; }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servletDemo");
    }

    @Override
    public String getServletInfo() {return null;}

    @Override
    public void destroy() {}
}

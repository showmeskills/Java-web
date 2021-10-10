package com.example.javawebday10.RequestDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-demo-1")
public class RequestDemo1 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        //1.获取请求方式:Get
        String method = req.getMethod();
        System.out.println("req-method--->"+method);//GET
        //2.获取虚拟路径
        String path = req.getContextPath();
        System.out.println("req-path---->"+path);//empty
        //3.获取current instance path
        String servletPath = req.getServletPath();
        System.out.println("servletPath--->"+servletPath);// /request-demo-1
        //4.获取get params
        String queryString = req.getQueryString();
        //http://localhost:8080/request-demo-1?name=Terry&password=12345--> name=Terry&password=12345
        System.out.println("get;queryString--->"+queryString);//if there are no query string it will return null
        //5.获取请求的url:
        String uri = req.getRequestURI();
        System.out.println("uri--->"+uri);// /request-demo-1
        StringBuffer sbUrl = req.getRequestURL();
        System.out.println("sbUrl--->"+sbUrl);//http://localhost:8080/request-demo-1
        //6.获取版本号:
        String protocol = req.getProtocol();
        System.out.println("protocol--->"+protocol);// HTTP/1.1
        //7.获取客户机的IP地址:
        String address = req.getRemoteAddr();
        System.out.println("ip-address--->"+address);// 0:0:0:0:0:0:0:1

    }
}

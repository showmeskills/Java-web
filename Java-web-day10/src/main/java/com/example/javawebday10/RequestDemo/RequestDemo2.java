package com.example.javawebday10.RequestDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request-demo-2")
public class RequestDemo2 extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //1.gain request header names
        Enumeration<String> headers = req.getHeaderNames();
        while(headers.hasMoreElements()){
            String names = headers.nextElement();
            String value = req.getHeader(names);
            System.out.println(names+'='+value);
        }
        //请求头数据的获取以及判断
        String header = req.getHeader("user-agent");
        if(header.contains("Chrome")){
            System.out.println("this is chrome browser");
        }
        //获取referer
        String referer = req.getHeader("referer");
        System.out.println("referer--->"+referer); // 会获取访问的url

        if(referer != null){
            if(referer.contains("8080")){
                res.setContentType("text/html;charset=utf-8");
                res.getWriter().write("<h1>Welcome my users</h1>");
            }else{
                res.setContentType("text/html;charset=utf-8");
                res.getWriter().write("<h1>You are not my member</h1>");
            }
        }
    }
}

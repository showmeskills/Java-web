package com.example.javawebday10;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet({"/d4","/dd4","/ddd4"}) 配置数组 当你访问/d4;/dd4;/ddd4 的时候都可以访问到当前的instance
//@WebServlet("/user/demo4") 当访问url 是/url/demo4 的时候可以访问到
//@WebServlet("/user/*") 当一级url是/url; 二级目录是/* 就是任何url都可以访问到当前instance e.g /user/1; /user/abc
//@WebServlet("/*") 当一级目录是/* 意思是当你输入的是'localhost:8080/demo',它会自动匹配其他类中的@WebServlet(value='/demo')
//@WebServlet("*.do") *.do; 例如.png;.txt;.html; 当你访问的时候任意前缀,但是必须要带后缀名,才能访问
/*
    .jsp -> <a href="hello-servlet.html">Hello Servlet</a>
    @WebServlet(name = "helloServlet", value = "*.html")
*/
@WebServlet(name = "helloServlet", value = "/abcd")
public class HttpServletDemo extends HttpServlet {
    private String message;
    private String content;
    @Override
    public void init() {
        this.message = "Hello World!";
        this.content = "<div style='color:red;font-size:20px;'>this is demo</div>";
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        // Hello
        PrintWriter out = res.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(this.content);
        out.println("</body></html>");
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
        System.out.println("dopost ...");
    }
    @Override
    public void doPut(HttpServletRequest req,HttpServletResponse res) throws IOException{

    }
    @Override
    public void doDelete(HttpServletRequest req,HttpServletResponse res) throws IOException{

    }
    @Override
    public void destroy(){}

}
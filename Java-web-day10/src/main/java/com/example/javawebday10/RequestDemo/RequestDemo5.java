package com.example.javawebday10.RequestDemo;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/request-demo-5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
    }
    @Override
    protected  void doGet(HttpServletRequest req,HttpServletResponse res){
        this.doPost(req,res);
    }
}

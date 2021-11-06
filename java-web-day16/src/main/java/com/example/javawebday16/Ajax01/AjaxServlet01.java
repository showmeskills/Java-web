package com.example.javawebday16.Ajax01;

import com.example.javawebday16.JacksonTest.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ajaxServlet")
public class AjaxServlet01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //1.getParameter 获取query parameter
        String params = req.getParameter("username");
        //2.处理业务逻辑
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(params);
        //3.响应处理
        //返回响应数据
        //把write中数据返回到前端
        //resp.getWriter().write(params);
        try {
            resp.getWriter().write( new Test().test4());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把整个页面返回到前端
        //req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        this.doPost(req,resp);
    }
}

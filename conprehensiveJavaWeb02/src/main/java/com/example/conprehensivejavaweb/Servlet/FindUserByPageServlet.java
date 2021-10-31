package com.example.conprehensivejavaweb.Servlet;


import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.Services.impl.UserServicesImpl;
import com.example.conprehensivejavaweb.domain.PageBean;
import com.example.conprehensivejavaweb.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");

        //1.获取参数
        String currentPage = req.getParameter("currentPage");//当前页码
        String rows = req.getParameter("rows");//每页显示条数

        //如果当前页码等于null或者控制空就赋值位1
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        //如果每页显示条数null或者控制空就赋值位5
        if(rows == null || "".equals(rows)){
            rows = "5";
        }

        //获取条件查询参数
        Map<String, String[]> condition = req.getParameterMap();


        //2.调用service查询
        UserServices service = new UserServicesImpl();
        PageBean<User> pb = service.findUserByPage(currentPage,rows,condition);

        System.out.println(pb);

        //3.将PageBean存入request
        req.setAttribute("pb",pb);
        req.setAttribute("condition",condition);//将查询条件存入request
        req.setAttribute("rows",rows);//自定以显示条数
        //4.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,res);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doPost(req,res);
    }
}

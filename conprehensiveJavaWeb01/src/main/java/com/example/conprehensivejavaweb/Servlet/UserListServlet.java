package com.example.conprehensivejavaweb.Servlet;

import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.Services.impl.UserServicesImpl;
import com.example.conprehensivejavaweb.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.调用UserService 完成查询
        UserServices userServices = new UserServicesImpl();
        List<User> users = userServices.findAll();
        //2.将list存入到request域中
        req.setAttribute("users",users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,res);
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req,res);
    }
}

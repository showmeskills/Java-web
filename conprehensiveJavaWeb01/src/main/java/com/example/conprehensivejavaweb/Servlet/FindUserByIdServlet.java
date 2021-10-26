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

@WebServlet("/findUserServlet")
public class FindUserByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //获取id
        String id = req.getParameter("id");
        //调用service 通过id查询
        UserServices services = new UserServicesImpl();
        User user = services.findUserById(id);
        //将user 存入 request.setAttribute
        req.setAttribute("user",user);
        //调转修改页面
        req.getRequestDispatcher("/update.jsp").forward(req,res);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req,res);
    }
}

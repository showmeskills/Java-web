package com.example.conprehensivejavaweb.Servlet;

import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.Services.impl.UserServicesImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUserServlet")
public class DelUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //gain query string getParameter
        String id = req.getParameter("id");
//        String queryString = req.getQueryString();
//        System.out.println(queryString);
        //call services
        UserServices services = new UserServicesImpl();
        services.deleteUser(id);
        res.sendRedirect(req.getContextPath()+"/userListServlet");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

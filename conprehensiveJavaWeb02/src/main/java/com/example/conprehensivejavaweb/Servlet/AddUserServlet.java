package com.example.conprehensivejavaweb.Servlet;


import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.Services.impl.UserServicesImpl;
import com.example.conprehensivejavaweb.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
        Map<String,String[]> map = req.getParameterMap();
        //3.封装对象
        User user = new User();
        try{
            BeanUtils.populate(user,map);
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //4.调用Service保存
        UserServices services = new UserServicesImpl();
        services.addUser(user);
        //5.跳转到userListServlet
        //res.sendRedirect(req.getContextPath()+"/userListServlet");
        res.sendRedirect(req.getContextPath()+"/findUserByPageServlet");
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req,res);
    }
}

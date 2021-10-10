package com.example.javawebday10.RequestDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/request-demo-3")
public class RequestDemo3 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("utf-8");
        //to gain request body; 前端发送过来的数据
        //BufferedReader reader = req.getReader();
        //read data
//        String line = null;
//        while((line = reader.readLine()) != null){
//            System.out.println("line---->"+line);
//        }
        //post 获取请求参数

        //根据参数名称获取参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("username--->"+username);//admin
        System.out.println("password---->"+password);

        //根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //获取所有请求的参数名称

        Enumeration<String> parameterNames = req.getParameterNames();
        /*while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name);
            String value = request.getParameter(name);
            System.out.println(value);
            System.out.println("----------------");
        }*/

        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        //遍历
        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset) {

            //获取键获取值
            String[] values = parameterMap.get(name);
            System.out.println(name);//username  password hobby
            for (String value : values) {
                System.out.println(value); // admin 123
            }

            System.out.println("-----------------");
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
/*
        //根据参数名称获取参数值
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);*/

        this.doPost(request,response);
    }
}

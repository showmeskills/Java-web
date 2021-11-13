package com.example.javawebday17redis.Jedis.Servlet;

import com.example.javawebday17redis.Jedis.services.Impl.ServicesImpl;
import com.example.javawebday17redis.Jedis.services.Services;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/provinceSerlvet")
public class JedisServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Services services = new ServicesImpl();
        String result = services.findAllJson();
        //设置响应结果
        resp.setContentType("application/json;charset=utf-8");
        //回到客户端
        resp.getWriter().write(result);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }
}

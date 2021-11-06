package com.example.javawebday16.Ajax01;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.获取用户名
        String username = req.getParameter("username");
        //设置响应的数据格式为json
        resp.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<>();
        if("terry".equalsIgnoreCase(username)){
            //is existed
            map.put("userExisted",true);
            map.put("msg","username 已经存在");
        }else{
            //not existed
            map.put("userExisted",false);
            map.put("msg","用户名可以用");
        }
        //将map专为json,并传递给客户端
        //1.专为json
        ObjectMapper mapper = new ObjectMapper();
        //发送给客户端
        //写法1
        //mapper.writeValue(resp.getWriter(),map);
        //写法2
        String json = mapper.writeValueAsString(map);
        resp.getWriter().write(json);
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        this.doPost(req,resp);
    }
}

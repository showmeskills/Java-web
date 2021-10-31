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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取用户前端的数据
        String verifiedCode = req.getParameter("verifiedCode");
        //验证码校验
        HttpSession session = req.getSession();
        String checkedCode = (String)session.getAttribute("CHECKCODE_SERVER");
        if(checkedCode != null && checkedCode.length() >0){
            if(!checkedCode.equalsIgnoreCase(verifiedCode)){
                //不相等;验证码不正确
                //设置返回jsp 值
                req.setAttribute("login_msg","验证码错误");
                //跳转到login.jsp
                req.getRequestDispatcher("/login.jsp").forward(req,res);
                //结束当前函数
                return;
            }
            //相等;验证码正确
            //获取所有数据
            Map<String,String[]> parameterMap = req.getParameterMap();
            //创建封装到User对象
            User user = new User();
            //传统写法
            //user.setUsername(parameterMap.get("username"));
            try {
                //推荐写法:
                //导入BeanUtils 包
                //import org.apache.commons.beanutils.BeanUtils;
                //BeanUtils.populate(实体类,前端发过来的parameter值);
                BeanUtils.populate(user,parameterMap);//然后user对象就有对应的数据了
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用Service的查询
            UserServices userServices = new UserServicesImpl();
            User loginUser = userServices.Login(user);

            //判断是否登录成功
            if(loginUser != null){
                //登录成功
                //将用户存入到session
                session.setAttribute("loginUser",loginUser);
                //跳转页面
                res.sendRedirect(req.getContextPath()+"/index.jsp");
                //req.getRequestDispatcher("/index.jsp").forward(req,res);
            }else{
                //登录失败
                //提示信息
                req.setAttribute("login_msg","用户名或密码错误");
                //跳转到login页面
                req.getRequestDispatcher("/login.jsp").forward(req,res);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
        this.doPost(req,res);
    }
}

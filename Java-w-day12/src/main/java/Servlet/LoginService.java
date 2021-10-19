package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/login")
public class LoginService extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //1.设置request 编码
        req.setCharacterEncoding("utf-8");
        //2.获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //3.先获取验证码
        HttpSession session = req.getSession();
        String checkCode_session = (String)session.getAttribute("checkCode_session");
        //删除session中存储的验证码；因为当第二次使用的时候需要把第一次删除
        session.removeAttribute("checkCode_session");
        //4.判断验证码是否正确
        if(checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)){
            //忽略大小写
            //验证正确
            //判断用户和密码是是否一致
            if("terry".equals(username) && "123456".equals(password)){
                //登录成功
                //存储用户信息
                session.setAttribute("user",username);
                //重定向到success.jsp
                res.sendRedirect(req.getContextPath()+"success.jsp");
            }else{
                //登录失败
                //存储提示信息到request中
                req.setAttribute("login_error","username or password is not correct");
                //使用request转发到登录页面
                req.getRequestDispatcher("/login.jsp").forward(req,res);
            }
        }else{
            //验证码不正确
            //存储提示信息到request
            req.setAttribute("cc_error","验证码错误");
            //转发request
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doPost(req,res);
    }
}

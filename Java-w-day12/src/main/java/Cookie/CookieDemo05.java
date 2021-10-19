package Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-demo-05")
public class CookieDemo05 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        //1.创建cookie对象
        Cookie cookie = new Cookie("x-share-params-api","你好");
        //设置path; 让服务器下部署的所有项目可以去共享cookie
        cookie.setPath("/");// 意思是以 '/' 开头可以访问到这个cookie值
        //3.发送cookie
        res.addCookie(cookie);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

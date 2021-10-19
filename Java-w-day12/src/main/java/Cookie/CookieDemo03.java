package Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-demo-03")
public class CookieDemo03 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        //发送多个cookie
        Cookie cookie1 = new Cookie("x-param-app","app");
        Cookie cookie2 = new Cookie("x-param-api","api");

        res.addCookie(cookie1);
        res.addCookie(cookie2);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}
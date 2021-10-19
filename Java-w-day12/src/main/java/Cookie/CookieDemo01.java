package Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-demo-01")
public class CookieDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        //1.create a cookie object
        Cookie cookie = new Cookie("x-params-api","hello");
        //2.发送cookie
        res.addCookie(cookie);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

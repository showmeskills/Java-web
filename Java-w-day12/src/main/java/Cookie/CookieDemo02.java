package Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-demo-02")
public class CookieDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        //3.获取cookie值; 获取的是数组
        Cookie[] cookies = req.getCookies();
        if(cookies.length > 0 && cookies != null){
            for(Cookie cookie:cookies){
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name+":"+value);
            }
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

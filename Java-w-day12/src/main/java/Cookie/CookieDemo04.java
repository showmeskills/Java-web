package Cookie;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie-demo-04")
public class CookieDemo04 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        //创建cookie对象
        Cookie cookie = new Cookie("msg","setMaxAge");
        //设置cookie存活时间
        //可以设置 3中类型 正数(当时间结束后cookie值消失)，0(生成cookie值后立即消失)，负数(就是默认情况，关闭浏览器后cookie值消失)
        cookie.setMaxAge(30);//将Cookie持久化到硬盘,30s 后会自动删除cookie文件
        res.addCookie(cookie);
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

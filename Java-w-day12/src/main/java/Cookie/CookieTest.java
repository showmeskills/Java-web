package Cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/cookie-test")
public class CookieTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //设置响应的消息体的数据格式以及编码
        res.setContentType("text/html;charset=utf-8");
        //1.获取所有cookie
        Cookie[] cookies = req.getCookies();
        boolean isFlag = false;
        //2.遍历cookie数组
        if(cookies.length > 0 && cookies != null){
            for(Cookie cookie:cookies){
                //3.获取cookie name and value
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                //4.判断cookie 名称是否为lastTime
                if("lastTime".equals(cookieName)){
                    //有该cookie,不是第一次访问
                    isFlag = true;//有lastTime的cookie
                    //设置cookie的value
                    //获取当前时间的字符串,重新设置Cookie的值,重新发送cookie
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String str_date = sdf.format(date);
                    System.out.println("编码前:"+str_date);//url编码
                    //解码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    System.out.println("编码后:"+str_date);
                    cookie.setValue(str_date);
                    //设置cookie存活时间
                    cookie.setMaxAge(60*60*24*30);//设置一个月
                    res.addCookie(cookie);

                    //响应数据
                    //获取cookie的value时间 获取最后一次访问时间
                    String value = cookie.getValue();
                    System.out.println("编码前:"+value);
                    //解码
                    value = URLDecoder.decode(str_date,"utf-8");
                    System.out.println("编码后:"+value);
                    cookie.setValue(value);
                    res.getWriter().write("<h1>欢迎回来,您上一次访问的时间"+value+"</h1>");
                    break;
                }
            }
        }
        Cookie cookie;
        if(cookies.length == 0 || cookies == null || isFlag == false ){
            //第一次访问
            //设置cookie的value
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String str_date = sdf.format(date);
            System.out.println("编码前:"+ str_date);
            str_date = URLEncoder.encode(str_date,"utf-8");
            System.out.println("编码后:"+str_date);
            cookie = new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24*30);
            res.addCookie(cookie);

            str_date = URLDecoder.decode(str_date,"utf-8");
            res.getWriter().write("<h1>您好,欢迎首次访问, 您首次访问时间:"+str_date+"</h1>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doPost(req,res);
    }
}

package ResponseDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/response-demo1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //访问responseDemo1,会自动跳转到responseDemo2资源
        //1.设置状态码为302
        //res.setStatus(302);
        //2.设置响应头location
        //res.setHeader("location","/response-demo2");

        req.setAttribute("msg","response");
        //动态获取虚拟目录 就是http:localhost:8080/..(这里就是虚拟目录)/api接口
        String contentPath = req.getContextPath();
        //简单的重定向方法
        res.sendRedirect(contentPath+"/response-demo2");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

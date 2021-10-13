package ResponseDemo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/response-demo2")
public class ResponseDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Object value = req.getAttribute("msg");
        System.out.println(value);
        res.setContentType("text/html;charset=utf-8");
        res.getWriter().write("<h1 style='color:red'>this is from response demo1"+value+" to response demo2</h1>");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

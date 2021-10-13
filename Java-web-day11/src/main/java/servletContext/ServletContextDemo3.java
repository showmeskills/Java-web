package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextDemo3")
public class ServletContextDemo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
          /*
            ServletContext功能：
               1. 获取MIME类型：
               2. 域对象：共享数据
               3. 获取文件的真实(服务器)路径
         */
        ServletContext sc = this.getServletContext();
        sc.setAttribute("msg","servlet context value");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

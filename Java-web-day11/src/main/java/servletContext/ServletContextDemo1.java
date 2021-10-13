package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
         /*

            ServletContext对象获取：
                1. 通过request对象获取
			        request.getServletContext();
                2. 通过HttpServlet获取
                    this.getServletContext();
         */
        //1.通过request 对象获取
        ServletContext sc1 =  req.getServletContext();
        //2.通过HttpServlet获取
        ServletContext sc2 = this.getServletContext();
        System.out.println(sc1.equals(sc2));//true
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

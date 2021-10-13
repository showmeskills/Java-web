package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
            /*
            ServletContext功能：
               1. 获取MIME类型：
                * MIME类型:在互联网通信过程中定义的一种文件数据类型
                    * 格式： 大类型/小类型   text/html		image/jpeg

                * 获取：String getMimeType(String file)
                2. 域对象：共享数据
                3. 获取文件的真实(服务器)路径
            */
        ServletContext sc = this.getServletContext();
        //定义一个fileName
        String filename = "a.jpg";
        //获取mime类型
        String mimeType = sc.getMimeType(filename);
        System.out.println(mimeType);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }
}

package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
          /*
              获取文件的真实(服务器)路径
         */
        ServletContext sc = req.getServletContext();
        //获取服务器文件的路径
        String b = sc.getRealPath("b.txt");
        //System.out.println(b);// --> /Users/yantinglong/Documents/java/java/Java-Web/Java-web-day11/target/Java-web-day11-1.0-SNAPSHOT/b.txt

        String c = sc.getRealPath("WEB-INF/c.txt");
        //System.out.println(c);

        String a = sc.getRealPath("WEB-INF/classes/a.txt");
        //System.out.println(a);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        this.doPost(req,res);
    }

    public static void readFileContent(){

    }
}

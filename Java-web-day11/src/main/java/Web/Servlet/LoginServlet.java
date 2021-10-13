package Web.Servlet;

import User.User;
import org.apache.commons.beanutils.BeanUtils;
import sql.UserSql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User loginUser = new User();
//        if(username != null && password != null){
//            loginUser.setUsername(username);
//            loginUser.setPassword(password);
//        }
        Map<String,String[]> map = req.getParameterMap();
        User loginUser = new User();
        try{
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        UserSql userSql = new UserSql();
        User user = userSql.login(loginUser);
        if(user == null){
            //login failed
            req.getRequestDispatcher("/failServlet").forward(req,res);
        }else{
            //login success
            //存储数据
            req.setAttribute("user",user);
            req.getRequestDispatcher("/successServlet").forward(req,res);
        }
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        this.doPost(req,res);
    }
}

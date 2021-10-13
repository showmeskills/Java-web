package Web.Servlet;

import User.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        User user = (User) req.getAttribute("user");
        res.setContentType("text/html;charset=UTF-8");
        res.getWriter().write("welcome back"+user.getUsername());
    }
    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

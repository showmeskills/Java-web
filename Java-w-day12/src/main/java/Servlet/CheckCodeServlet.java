package Servlet;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet("/check-code-servlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int width = 100;
        int height = 50;

        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);
        g.fillRect(0,0,width,height);

        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4;i++){
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(ch+"",width/5*i,height/2);
        }

        String checkCode_session = sb.toString();
        req.getSession().setAttribute("checkCode_session",checkCode_session);

        g.setColor(Color.GREEN);

        g.setColor(Color.GREEN);

        for(int i=0; i < 10; i++){
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }

        ImageIO.write(image,"jpg",res.getOutputStream());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

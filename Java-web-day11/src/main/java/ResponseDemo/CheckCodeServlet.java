package ResponseDemo;

import javax.imageio.ImageIO;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int width = 100;
        int height = 50;
        //1.创建一个对象,在内存中图片(验证码图片对象)
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        //2.美化图片
        //2.1填充背景颜色
        Graphics g = image.getGraphics();
        g.setColor(Color.pink);
        g.fillRect(0,0,width,height);
        //2.2画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);// -1 防止重叠

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";

        //生成随机角标
        Random random = new Random();
        for(int i = 0; i < 4; i++){
            int index = random.nextInt(str.length());
            char c = str.charAt(index);
            g.drawString(c+"",width/5*i,height/2);//显示验证字符 设置距离
        }
        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标
        for(int i=0; i < 10; i++){
            int x1 = random.nextInt(width);
            int x2 =random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }
        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",res.getOutputStream());
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

package DownLoad;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/downloadServlet")
public class DownLoadDemo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //1.获取请求参数,文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载到文件
        //2.1找到文件服务器路径
        ServletContext sc = this.getServletContext();
        String path = sc.getRealPath("/img/"+filename);
        //2.2用字节流 加载进内存
        FileInputStream fis = new FileInputStream(path);
        //3.设置Response响应头
        //3.1设置响应头类型
        String mimeType = sc.getMimeType(filename);
        res.setHeader("content-type",mimeType);
        //解决请求头乱码的问题
        //解决中文文件名问题
        //1、获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //2、使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent,filename);
        //3.2设置响应头打开方式
        res.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流数据写出到输出流
        ServletOutputStream outputStream = res.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
        this.doPost(req,res);
    }
}

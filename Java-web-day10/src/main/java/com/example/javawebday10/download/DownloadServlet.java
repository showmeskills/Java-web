package com.example.javawebday10.download;

import com.example.javawebday10.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //1.获取请求参数,判断图片还是音频
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载到文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realpath = servletContext.getRealPath("./img/"+filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realpath);
        //3.设置响应头response
        //3.1设置响应头的类型 content-type
        String mimeType = servletContext.getMimeType(filename);
        res.setHeader("content-type","mimeType");
        //3.2设置响应头打开方式:content-disposition;下载名称
        //解决中文文件名的问题
        //1.获取user-agent请求头
        String agent = req.getHeader("user-agent");
        //2.使用工具类方法编码文件即可
        filename = DownLoadUtils.getFileName(agent,filename);
        res.setHeader("content-disposition","attachment;filename="+filename);

        //4.将输入流数据写出到输出流
        ServletOutputStream outputStream = res.getOutputStream();
        byte[] buff = new byte[1024*8];
        int len = 0;
        while((len = fis.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        fis.close();
    }
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req,res);//doPost 和 doGet 可以可以只写一套代码
    }
}

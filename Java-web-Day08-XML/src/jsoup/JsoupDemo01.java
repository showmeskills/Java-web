package jsoup;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;


//快速入门
public class JsoupDemo01 {
    public static void main(String[] args) throws Exception {
        //获取students.xml 文件路径
        //String path = new File(new File("").getAbsolutePath(),"src/students.xml").toString();
        String path = JsoupDemo01.class.getClassLoader().getResource("students.xml").getPath();
        //获取DOM 对象
        //Document document = new Document(path);
        //解析xml文档，加载文档进内,获取dom树
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取元素对象
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());
        //获取第一个name的element 对象
        Element element = name.get(0);
        //获取数据 获取dom里面的 text 内容
        String username = element.text();
        System.out.println(username);
    }
}

package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupDemo03 {
    public static void main(String[] args) throws Exception {
//        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");//代表网络中的一个资源路径
//        Document document = Jsoup.parse(url, 10000);
//        File newHmtl = new File( new File("").getAbsolutePath(),"src/index.html");
//        FileOutputStream fos = new FileOutputStream(newHmtl);
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//        bos.write(document.toString().getBytes());
//        bos.flush();
//        bos.close();

        String path = JsoupDemo03.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");
        Elements elements = document.getElementsByTag("student");
        Elements id = document.getElementsByAttribute("id");
        Elements value = document.getElementsByAttributeValue("number","sixstar_0002");
        Element element = document.getElementById("sixstar");
        System.out.println(element);
    }
}

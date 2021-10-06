package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

public class JsoupDemo02 {
    public static void main(String[] args) throws Exception {
        //parse解析xml字符串
        String str = "    <student number=\"sixstar_0001\">\n" +
                "        <name id=\"sixstar\">\n" +
                "            <firstname>Terrence</firstname>\n" +
                "            <lastname>YAN</lastname>\n" +
                "        </name>\n" +
                "        <age>18</age>\n" +
                "        <gender>female</gender>\n" +
                "    </student>";

        //解析xml文档，加载文档进内,获取dom树
        Document document = Jsoup.parse(str);
        System.out.println(document);
    }
}

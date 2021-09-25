package Demo02ClassLoder;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ClassLoaderTest1 {

    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest1.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        //调用系统类加载器的getParent()：获取扩展类加载器
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);//sun.misc.Launcher$ExtClassLoader@64a294a6
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类的。
        ClassLoader coreClassLoader = classLoaderParent.getParent();
        System.out.println(coreClassLoader);//获取不到是因为引导类加载器是由c++编写的
        //自定义类加载器
        ClassLoader customClassLoader = String.class.getClassLoader();
        System.out.println(customClassLoader);//因为String的库是存在引导类加载器中
    }
    /*
    Properties：用来读取配置文件。
     */
    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        //此时的文件默认在当前的module下。
        //读取配置文件的方式一：IO流读取
        File path = new File(new File("").getAbsolutePath(),"src/jdbc.properties");
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
        Set<String> set = properties.stringPropertyNames();
        for(String key:set){
            String value = properties.getProperty(key);
            System.out.println(key+"="+value);
        }
        fis.close();
        //读取配置文件的方式二：使用ClassLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader cl = ClassLoaderTest1.class.getClassLoader();
        InputStream is = cl.getResourceAsStream("db.properties");
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println("user="+user+",password="+password);
    }

}

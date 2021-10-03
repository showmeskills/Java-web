package utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    //文件的读取,只需要读取一次即可拿到这些值。使用静态代码快
    static{
        try {
            //读取资源文件
            //1.创建Properties集合
            Properties properties = new Properties();
            /*
                方法一:
                InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
                properties.load(is);
                url = properties.getProperty("url");
                user = properties.getProperty("user");
                password = properties.getProperty("password");
                driver = properties.getProperty("driver");
            */
            //方法二:
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            //2.获取src路径下的文件的方式 ---->通过反射 ClassLoader类加载器
            properties.load(new FileReader(path));
            //3.赋值操作
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //4.注册驱动
            Class.forName(driver);

            } catch (IOException e) {
             e.printStackTrace();
            }catch (ClassNotFoundException e){
             e.printStackTrace();
        }
    }
    //获取链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    //释放资源
    public static void close (Statement statement, Connection connection, ResultSet resultSet){
        if(statement != null && connection !=null && resultSet != null){
            try{
                resultSet.close();
                statement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

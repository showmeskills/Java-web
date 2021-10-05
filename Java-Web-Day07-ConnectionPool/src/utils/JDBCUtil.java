package utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    static{
        try{
            Properties properties = new Properties();
            ClassLoader classLoader = JDBCUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            properties.load(new FileReader(path));
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            Class.forName(driver);
        }catch(IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
    public static void close (Statement statement,Connection connection, ResultSet resultSet){
        if(statement != null && connection != null && resultSet != null){
            try{
                resultSet.close();
                statement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    public static void close (Statement statement,Connection connection){
        if(statement != null || connection != null){
            try{
                statement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public static void close (Statement statement){
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

}

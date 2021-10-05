package Demo03Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtil {
    private static DataSource ds;
    static{
        //1.加载配置文件
        try{
            Properties properties = new Properties();
            InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
        }
    };
    //获取链接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    //关闭资源
    public static void close(Statement statement, Connection connection, ResultSet resultSet){
        if(resultSet !=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(statement != null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(resultSet != null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    //获取链接池方法
    public static DataSource getDataSource(){
        return ds;
    }
}

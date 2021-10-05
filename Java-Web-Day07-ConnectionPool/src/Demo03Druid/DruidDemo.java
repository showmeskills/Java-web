package Demo03Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String ...args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties properties = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        properties.load(is);
        //4.获取链接对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        //5.获取链接
        Connection connection = ds.getConnection();
        System.out.println(connection);
    }
}

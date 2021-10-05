package Demo02C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Demo {
    public static void main(String ...args)throws Exception {
        //1.创建书库链接对象
        DataSource ds = new ComboPooledDataSource();
        //2.获取链接对象
        Connection connection = ds.getConnection();

        System.out.println(connection);
    }
}

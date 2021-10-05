package Demo02C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Demo2 {
    public static void main(String ...args)throws Exception {
        //1.创建书库链接对象
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        //2.获取链接对象
        for(int i = 0; i < 11; i++){
            Connection connection = ds.getConnection();
            System.out.println(i+":"+connection);
            if(i == 5){
                connection.close();
            }
        }
    }
}

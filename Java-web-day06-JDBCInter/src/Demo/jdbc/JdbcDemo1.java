package Demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main (String[] args) throws ClassNotFoundException, SQLException {
        //2.注册驱动 -- 创建一个实现类
        Class.forName("com.mysql.cj.jdbc.Driver");// 方式一
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 方式二:
        //3.获取数据链接对象 -- 获取数据库的链接，然后可以操作数据库 serverTimezone=UTC 时区; serverTimezone=Aisa/shanghai
        //DriverManager 作用:
        //1.管理和注册驱动
        //2.创建数据库的链接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&characterEncoding=utf8","root","");
        //4.定义sql
        String sql = "update account set balance= 10000 where id = 2";
        //5.获取执行sql语句的对象statement
        Statement statement =  connection.createStatement();
        //6.执行sql,接受返回结果
        int index = statement.executeUpdate(sql);
        //7.处理结果
        System.out.println(index);//返回1，一条数据受到影响
        //8.释放资源
        statement.close();
        connection.close();
    }
}

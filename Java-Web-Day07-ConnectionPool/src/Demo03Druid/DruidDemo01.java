package Demo03Druid;

import utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DruidDemo01 {
    public static void main(String ...args) throws Exception{
        //1.获取链接
        Connection connection = DruidUtil.getConnection();
        //2.定义sql语句
        String sql = "insert into account values(null,?,?)";
        //3.获取执行对象
        PreparedStatement pstmt = connection.prepareStatement(sql);
        //4.给问号赋值
        pstmt.setString(1,"王五");
        pstmt.setDouble(2,10000);
        //5.执行sql
        int count = pstmt.executeUpdate();
        System.out.println(count);
        //6.释放资源
        DruidUtil.close(pstmt,connection,null);
    }
}

package Demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo4Delete {
    public static void main(String ...args) {
        Connection connection = null;
        Statement statement = null;
        String dbUrl = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&characterEncoding=utf8";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "delete from account where id=3";
            connection = DriverManager.getConnection(dbUrl,"root","");
            statement = connection.createStatement();
            int count = statement.executeUpdate(sql);
            System.out.println(count);
            if(count > 0){
                System.out.println("删除成功");
            }else{
                System.out.println("删除失败");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement != null && connection !=null){
                try{
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

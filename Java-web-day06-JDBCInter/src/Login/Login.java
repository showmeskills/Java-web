package Login;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static boolean logon(String username, String password) {
        if(username == null || password == null){
            return false;
        }
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "select * from usertable where username= '"+username+"' and password='"+password+"'";
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.close(statement,connection,resultSet);
        }
        return false;
    }

    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();

        boolean isLogon = Login.logon(username,password);
       if(isLogon){
           System.out.println("登录成功");
       }else{
           System.out.println("登录失败");
       }
    }
}

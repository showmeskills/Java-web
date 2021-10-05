package Logon;

import utils.JDBCUtil;

import java.sql.*;
import java.util.Scanner;

public class Logon {

    public static boolean login(String username,String password){
        if(username == null || password == null){
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;//使用statement 子接口 PreparedStatement
        ResultSet resultSet = null;
        try{
            connection = JDBCUtil.getConnection();
            //使用? 作为占位符
            String sql = "select * from usertable where username= ? and password= ? ";
            preparedStatement =  connection.prepareStatement(sql);//sql 语句预编译
            //给占位符赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement,connection,resultSet);
        }
        return false;
    }

    public static void main(String ...args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        String username = scanner.next();
        System.out.println("输入密码");
        String password = scanner.next();

        boolean isLogon = Logon.login(username,password);
        if(isLogon){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}

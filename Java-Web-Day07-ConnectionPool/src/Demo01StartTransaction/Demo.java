package Demo01StartTransaction;

import utils.JDBCUtil;

import java.sql.*;

public class Demo {
    public static void task() {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try{
            connection = JDBCUtil.getConnection();
            //开始事务
            connection.setAutoCommit(false);
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement1.setDouble(1,500);
            preparedStatement1.setInt(2,1);
            preparedStatement2.setDouble(1,500);
            preparedStatement2.setInt(2,2);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();
            //无异常则提交事务
            connection.commit();
        }catch(SQLException e){
            if(connection != null){
                try {
                    //回滚 捕获异常
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtil.close(preparedStatement1);
            JDBCUtil.close(preparedStatement2,connection);
        }
    }
    public static void main(String ...args){
        Demo.task();
    }
}

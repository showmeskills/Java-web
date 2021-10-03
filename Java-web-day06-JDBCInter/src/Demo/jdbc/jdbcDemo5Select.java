package Demo.jdbc;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class jdbcDemo5Select {
    public static void main(String ...args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        String dbUrl = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&characterEncoding=utf8";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from account";
            connection = DriverManager.getConnection(dbUrl,"root","");
            statement = connection.createStatement();
            results = statement.executeQuery(sql);
            while(results.next()){
                //String id = results.getString("id");
                int id = results.getInt(1);//getInt() 1就是取id，2就是取name,3就是取balance
                String name = results.getString("name");//或者使用getString("id/name/balance")
                String balance = results.getString("balance");
                System.out.println(id + name + balance);
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement != null && connection !=null && results != null){
                try{
                    results.close();
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

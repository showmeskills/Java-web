package Demo.jdbc;

import domain.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo6Emp {
    public List<Emp> findAll(){
        List<Emp> list = new ArrayList<Emp>();
        Connection connection = null;
        Statement statement = null;
        ResultSet results = null;
        String dbUrl = "jdbc:mysql://localhost:3306/db1?serverTimezone=UTC&characterEncoding=utf8";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String sql = "select * from emp";
            connection = DriverManager.getConnection(dbUrl,"root","");
            statement = connection.createStatement();
            results = statement.executeQuery(sql);
            while(results.next()){
                int id = results.getInt("id");
                String name = results.getString("employee_name");
                int jobId = results.getInt("job_id");
                int mgr = results.getInt("mgr");
                Date joinDate = results.getDate("join_date");
                int salary = results.getInt("salary");
                double bonus = results.getDouble("bonus");
                int dept_id = results.getInt("dept_id");
                list.add(new Emp(id,name,jobId,mgr,joinDate,salary,bonus,dept_id));
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
        return list;
    }


    public static void main(String ...args){
        List<Emp> lists = new jdbcDemo6Emp().findAll();
        for(Emp list : lists){
            System.out.println(list);
        }
    }
}

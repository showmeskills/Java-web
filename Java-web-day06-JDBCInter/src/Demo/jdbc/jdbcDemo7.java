package Demo.jdbc;

import domain.Emp;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcDemo7 {
    public List<Emp> findAll(){
        List<Emp> list = new ArrayList<Emp>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "select * from emp";
            connection = JDBCUtils.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("employee_name");
                int jobId = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joinDate = resultSet.getDate("join_date");
                int salary = resultSet.getInt("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");
                list.add(new Emp(id,name,jobId,mgr,joinDate,salary,bonus,dept_id));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
           JDBCUtils.close(statement,connection,resultSet);
        }
        return list;
    }


    public static void main(String ...args){
        List<Emp> lists = new jdbcDemo7().findAll();
        for(Emp list : lists){
            System.out.println(list);
        }
    }
}

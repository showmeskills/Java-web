package jdbcTemplateDemo04;

import Demo03Druid.DruidUtil;
import domain.Emp;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo02 {
    //1.获取jdbcTemplate(定义全局)
    private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
    //修改 1 号数据的salary 为10000
    @Test
    public void test1(){
        //定义sql
        String sql = "update emp set salary = 10000 where id = ?";
        int count = template.update(sql,1001);
        System.out.println(count);
    }
    //添加记录
    @Test
    public void test2(){
        String sql = "insert into emp (id,employee_name,dept_id) values (?,?,?)";
        int count = template.update(sql,1015,"Terry",10);
        System.out.println(count);
    }
    //删除
    @Test
    public void test3(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql,1015);
        System.out.println(count);
    }
    //查询id为1001的记录，将其封装为Map集合
    //queryForMap 这个方法的长度只能是1,意思就是只能搜索出一条数据
    @Test
    public void test4(){
        String sql = "select * from emp where id = ?";
        Map<String,Object> map = template.queryForMap(sql,1001);
        System.out.println(map);
    }
    //查询所有记录
    @Test
    public void test5(){
        String sql = "select * from emp";
        List<Map<String,Object>> maps = template.queryForList(sql);
        for(Map<String,Object> map:maps){
            System.out.println(map);
        }
    }
    //1.查询所有记录 不推荐
    @Test
    public void test6(){
        //2.定义
        String sql = "select * from emp";
        //3.执行sql
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp = new Emp();
                int id = resultSet.getInt("id");
                String employee_name = resultSet.getString("employee_name");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date join_date = resultSet.getDate("join_date");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                return emp;
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    //推荐写法
    @Test
    public void test7(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp :list){
            System.out.println(emp);
        }
    }
    @Test
    public void test8(){
        String sql = "select count(id) from emp";
        Integer integer = template.queryForObject(sql,Integer.class);
        System.out.println(integer);
    }
}

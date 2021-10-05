package jdbcTemplateDemo04;

import Demo03Druid.DruidUtil;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo01 {
    public static void main(String ...args){
        //1.导入jar包
        //2.创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
        //3.调用方法
        String sql = "update account set balance = 5000 where id = ?";
        int count = template.update(sql,4);//直接给id 赋值
        System.out.println(count);
    }
}

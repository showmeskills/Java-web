package com.example.conprehensivejavaweb.Modals.impl;

import com.example.conprehensivejavaweb.Modals.UserDB;
import com.example.conprehensivejavaweb.domain.User;
import com.example.conprehensivejavaweb.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDBImpl implements UserDB {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //select all users
    @Override
    public List<User> findAll() {
        //逻辑代码 使用jdbc操作数据库
        //1.定义sql
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }
    //login in user
    @Override
    public User findUserByUsernameAndPassword(String username,String password){
        try{
            String sql = "select * from user where username = ? and password = ?";
            //使用template.queryForObject 的期望查出来的值 只有一个 所以需要捕获异常
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    username,
                    password);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
    //add user
    @Override
    public void add(User user){
        //定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        this.template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());
    }
    //delete user
    @Override
    public void delete(int id){
        String sql = "delete from user where id = ?";
        this.template.update(sql,id);
    }
    //find a User By id
    @Override
    public User findUserById(int id){
        try{
            String sql = "select * from user where id = ?";
            //使用template.queryForObject 的期望查出来的值 只有一个 所以需要捕获异常
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    id);
            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    //update a user
    @Override
    public void updateUser(User user){
        String sql = "update user set name = ? ,gender = ?,age = ?,address = ?,qq = ?,email = ? where id = ?";
        this.template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String,String[]> condition){
        //1.初始化模版
        String sql = "select count(*) from user where 1 = 1";//1 = 1目前没有什么,是为了再后面的sql语句做拼接
        //模糊查询 start
        StringBuilder sb = new StringBuilder(sql);//放在 StringBuilder 是为了以后可以追加条件
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<>();
        for(String key :keySet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值,拼接条件
                sb.append(" and " + key + " like ?");
                params.add("%"+value+"%");
            }
        }
        //最终的sql 语句
        //select count(*) from user where 1 = 1 and name like ? and address like ? and email like ?
        //[%terry%, %tas%, %465446853@qq.com%]
        //SQL语句
        System.out.println(sb.toString());
        //参数
        System.out.println(params);
        //模糊查询 end
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }
    @Override
    public List<User> findByPage(int start, int rows, Map<String,String[]> condition){
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        //2.遍历map
        Set<String> keySet = condition.keySet();
        //定义参数的集合
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value 是否有值
            if(value != null && !"".equals(value)){
                //有值
                //sql 拼接select * from user where 1 = 1 and key:name like %value:terry%
                //sql 拼接select * from user where 1 = 1 and key:address like %value:tas%
                //sql 拼接select * from user where 1 = 1 and key:email like %value:465446853@qq.com%
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//?条件的值
            }
        }
        //添加分页查询
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params);
        // select * from user where 1 = 1 and name like ?  and address like ?  and email like ?  limit ?,?
        //[%terry%, %tas%, %465446853@qq.com%, 0, 5]
        return this.template.query(sql, new BeanPropertyRowMapper<User>(User.class),params.toArray());
    }
}

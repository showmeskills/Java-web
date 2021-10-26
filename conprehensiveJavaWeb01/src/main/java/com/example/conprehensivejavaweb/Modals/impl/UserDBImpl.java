package com.example.conprehensivejavaweb.Modals.impl;

import com.example.conprehensivejavaweb.Modals.UserDB;
import com.example.conprehensivejavaweb.domain.User;
import com.example.conprehensivejavaweb.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
}

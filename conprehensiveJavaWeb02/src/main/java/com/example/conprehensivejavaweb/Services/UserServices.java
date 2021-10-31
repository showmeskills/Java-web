package com.example.conprehensivejavaweb.Services;

import com.example.conprehensivejavaweb.domain.PageBean;
import com.example.conprehensivejavaweb.domain.User;

import java.util.List;
import java.util.Map;


public interface UserServices {
    //查询所有用户
    public List<User> findAll();
    //用户登录
    public User Login(User user);
    //add user
    public void addUser(User user);
    //delete user
    public void deleteUser(String id);
    //find a user by id
    public User findUserById(String id);
    //update a user
    public void updateUser(User user);
    //delete selected users
    public void deleteSelectedUsers(String[] ids);
    //分页查询条件
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String,String[]> condition);
}

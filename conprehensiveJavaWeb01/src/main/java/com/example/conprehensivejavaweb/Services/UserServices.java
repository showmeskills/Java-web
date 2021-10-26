package com.example.conprehensivejavaweb.Services;

import com.example.conprehensivejavaweb.domain.User;

import java.util.List;


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
}

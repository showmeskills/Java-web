package com.example.conprehensivejavaweb.Services.impl;


import com.example.conprehensivejavaweb.Modals.impl.UserDBImpl;
import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.domain.User;

import java.util.List;

public class UserServicesImpl implements UserServices {
    private UserDBImpl userDBImpl = new UserDBImpl();
    @Override
    public List<User> findAll() {
        //调用dao层查询所有
        return this.userDBImpl.findAll();
    }
    @Override
    public User Login(User user){
        return this.userDBImpl.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }
    @Override
    public void addUser(User user){
        this.userDBImpl.add(user);
    }
    @Override
    public void deleteUser(String id){
        this.userDBImpl.delete(Integer.parseInt(id));
    }
    @Override
    public User findUserById(String id){
        return this.userDBImpl.findUserById(Integer.parseInt(id));
    }
    @Override
    public void updateUser(User user){
        this.userDBImpl.updateUser(user);
    }
}

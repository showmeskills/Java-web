package com.example.conprehensivejavaweb.Modals;

import com.example.conprehensivejavaweb.domain.User;

import java.util.List;

//持久层
public interface UserDB {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username,String password);

    public void add(User user);

    public void delete(int id);

    public User findUserById (int id);

    public void updateUser(User user);
}

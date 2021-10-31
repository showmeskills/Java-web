package com.example.conprehensivejavaweb.Modals;

import com.example.conprehensivejavaweb.domain.User;

import java.util.List;
import java.util.Map;

//持久层
public interface UserDB {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username,String password);

    public void add(User user);

    public void delete(int id);

    public User findUserById (int id);

    public void updateUser(User user);

    /*
    * 查询总记录
    * @return
    * @param condition
    * */
    public int findTotalCount(Map<String,String[]> condition);
    //分页查询
    public List<User> findByPage(int start, int rows, Map<String,String[]> condition);
}

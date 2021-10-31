package com.example.conprehensivejavaweb.Services.impl;


import com.example.conprehensivejavaweb.Modals.impl.UserDBImpl;
import com.example.conprehensivejavaweb.Services.UserServices;
import com.example.conprehensivejavaweb.domain.PageBean;
import com.example.conprehensivejavaweb.domain.User;

import java.util.List;
import java.util.Map;

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
    @Override
    public void deleteSelectedUsers(String[] ids){
        if (ids != null && ids.length > 0){
            for(String id : ids){
                this.userDBImpl.delete(Integer.parseInt(id));
            }
        }
    }
    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String,String[]> condition){

        int currentPage = Integer.parseInt(_currentPage);//当前页面
        int rows = Integer.parseInt(_rows);//每页显示的条数
        //当前页码小于0的时候设置成1
        if(currentPage <=0) {
            currentPage = 1;
        }
        //1.创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        //2.设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        //3.调用dao查询总记录数
        //condition查询条件
        int totalCount = this.userDBImpl.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //4.调用dao查询List集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = this.userDBImpl.findByPage(start,rows,condition);
        pb.setList(list);


        //5.计算总页码
        int totalPage = (totalCount % rows)  == 0 ? totalCount/rows : (totalCount/rows) + 1;
        pb.setTotalPage(totalPage);


        return pb;
    }
}

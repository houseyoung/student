package com.myframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myframework.entity.User;
import com.myframework.mapper.UserMapper;
import com.myframework.service.UserService;

import java.util.List;

/**
 * Created by houseyoung on 15/9/24 22:26.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> listUser(){
        return userMapper.listUser();
    }

    @Override
    public User queryById(int id){
        return userMapper.queryById(id);
    }

    @Override
    public boolean checkLogin(User user){
    //TODO:将密码加密
        return userMapper.countByUsernameAndPassword(user.getUsername(), user.getPassword()) > 0 ? true : false;
    }

    @Override
    public int checkRole(User user) {
        return userMapper.checkRole(user.getUsername(), user.getPassword());
    }
}
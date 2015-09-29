package com.myframework.service.impl;

import com.myframework.util.MD5Util;
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
    public int checkRole(User user) {
        return userMapper.checkRole(user.getUsername(), MD5Util.md5(user.getPassword()));
    }

    @Override
    public void insert(User user){
        user.setPassword(MD5Util.md5(user.getPassword()));
        userMapper.insert(user);
    }
}
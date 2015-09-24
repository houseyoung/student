package com.myframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myframework.entity.User;
import com.myframework.mapper.UserMapper;
import com.myframework.service.UserService;
/**
 * Created by houseyoung on 15/9/24 22:26.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

}
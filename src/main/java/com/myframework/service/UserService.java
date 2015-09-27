package com.myframework.service;

import com.myframework.entity.User;

import java.util.List;

/**
 * Created by houseyoung on 15/9/24 22:25.
 */
public interface UserService {
    public List<User> listUser();

    public User queryById(int id);

    public boolean checkLogin(User user);

    public int checkRole(User user);
}

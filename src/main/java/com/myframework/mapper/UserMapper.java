package com.myframework.mapper;

import com.myframework.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/9/24 22:23.
 */
public interface UserMapper {
    public List<User> listUser();

    public User queryById(int id);

    public int countByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

    public int checkRole(@Param("username")String username, @Param("password")String password);
}

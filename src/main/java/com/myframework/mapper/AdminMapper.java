package com.myframework.mapper;

import com.myframework.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:31.
 */
public interface AdminMapper {
    public List<Admin> listAdmin(@Param("keywords") String keywords, @Param("id") int id);

    public void insertAdmin(@Param("admin") Admin admin);

    public void delete(@Param("id") int id);

    public Admin queryById(@Param("id") int id);

    public void update(@Param("admin") Admin admin);

    public int checkLogin(@Param("username")String username, @Param("password")String password);

    public Admin showHimself(@Param("id") int id);

    public void editHimself(@Param("admin") Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name);

    public int getIdByUsername(@Param("username")String username);
}

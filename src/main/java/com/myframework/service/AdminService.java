package com.myframework.service;

import com.myframework.dto.AdminDto;
import com.myframework.entity.Admin;
import com.myframework.util.MD5Util;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:27.
 */
public interface AdminService {
    public List<Admin> listAdmin(@Param("keywords") String keywords, @Param("id") int id);

    public void insertAdmin(@Param("admin") Admin admin);

    public void delete(@Param("id") int id);

    public Admin queryById(@Param("id") int id);

    public void update(@Param("admin") Admin admin);

    public int checkRole(@Param("admin") Admin admin);

    public Admin showHimself(@Param("id") int id);

    public void editHimself(@Param("admin") Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name);

    //通过Username获取ID，以解决Controller无法得到当前登录ID的问题
    public int getIdByUsername(@Param("admin") Admin admin);

    public List<AdminDto> listInstructor(@Param("classId") int classId, @Param("keywords") String keywords);

    public void insertInstructor(@Param("adminDto") AdminDto adminDto);

    public void updateInstructor(@Param("adminDto") AdminDto adminDto);

    public AdminDto queryInstructorById(@Param("id") int id);

    //通过Username获取ClassID，以解决Controller无法得到当前登录ClassID的问题
    public int getClassIdByUsername(@Param("username")String username);

    public AdminDto showInstructorHimself(@Param("id") int id);

    public void editInstructorHimself(@Param("admin") Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name);
}

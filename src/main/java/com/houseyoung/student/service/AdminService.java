package com.houseyoung.student.service;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:27.
 */
public interface AdminService {
    public List<Admin> listAdmin(String keywords, int id);

    public void insertAdmin(Admin admin);

    public void delete(int id);

    public Admin queryById(int id);

    public void update(Admin admin);

    public int checkRole(Admin admin);

    public Admin showHimself(int id);

    public void editHimself(Admin admin, String username, String password, String name);

    //通过Username获取ID，以解决Controller无法得到当前登录ID的问题
    public int getIdByUsername(@Param("admin") Admin admin);

    public List<AdminDto> listInstructor(int classId,  String keywords);

    public void insertInstructor(AdminDto adminDto);

    public void updateInstructor(AdminDto adminDto);

    public AdminDto queryInstructorById(int id);

    //通过Username获取ClassID，以解决Controller无法得到当前登录ClassID的问题
    public int getClassIdByUsername(String username);

    public AdminDto showInstructorHimself(int id);

    public void editInstructorHimself(Admin admin, String username, String password, String name);
}

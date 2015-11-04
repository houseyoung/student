package com.houseyoung.student.service;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:27.
 */
public interface AdminService {
    public List<Admin> listAdmin(String keywords, int id) throws Exception;

    public void insertAdmin(Admin admin) throws Exception;

    public void delete(int id) throws Exception;

    public Admin queryById(int id) throws Exception;

    public void update(Admin admin) throws Exception;

    public int checkRole(Admin admin) throws Exception;

    public Admin showHimself(int id) throws Exception;

    public void editHimself(Admin admin, String username, String password, String name) throws Exception;

    //通过Username获取ID，以解决Controller无法得到当前登录ID的问题
    public int getIdByUsername(@Param("admin") Admin admin) throws Exception;

    public List<AdminDto> listInstructor(int classId,  String keywords) throws Exception;

    public void insertInstructor(AdminDto adminDto) throws Exception;

    public void updateInstructor(AdminDto adminDto) throws Exception;

    public AdminDto queryInstructorById(int id) throws Exception;

    //通过Username获取ClassID，以解决Controller无法得到当前登录ClassID的问题
    public int getClassIdByUsername(String username) throws Exception;

    public AdminDto showInstructorHimself(int id) throws Exception;

    public void editInstructorHimself(Admin admin, String username, String password, String name) throws Exception;
}

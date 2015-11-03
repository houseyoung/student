package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.AdminDto;
import com.houseyoung.student.entity.Admin;
import com.houseyoung.student.mapper.AdminMapper;
import com.houseyoung.student.service.AdminService;
import com.houseyoung.student.util.MD5Util;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/23 22:30.
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> listAdmin(String keywords, @Param("id") int id){
        return adminMapper.listAdmin(keywords, id);
    }

    @Override
    public void insertAdmin(Admin admin){
        admin.setPassword(MD5Util.md5(admin.getUsername()));
        adminMapper.insertAdmin(admin);
    }

    @Override
    public void delete(int id)  {
        adminMapper.delete(id);
    }

    @Override
    public Admin queryById(int id) {
        return adminMapper.queryById(id);
    }

    @Override
    public void update(Admin admin){
        adminMapper.update(admin);
    }

    @Override
    public int checkRole(Admin admin){
        return adminMapper.checkRole(admin.getUsername(), MD5Util.md5(admin.getPassword()));
    }

    @Override
    public Admin showHimself(int id) {
        return adminMapper.showHimself(id);
    }

    @Override
    public void editHimself(Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name) {
        adminMapper.editHimself(admin, username, MD5Util.md5(password), name);
    }

    @Override
    public int getIdByUsername(Admin admin){
        return adminMapper.getIdByUsername(admin.getUsername());
    }

    @Override
    public List<AdminDto> listInstructor(int classId, @Param("keywords") String keywords){
        return adminMapper.listInstructor(classId, keywords);
    }

    @Override
    public void insertInstructor(AdminDto adminDto){
        adminDto.setPassword(MD5Util.md5(adminDto.getPassword()));
        adminMapper.insertInstructor(adminDto);
    }

    @Override
    public void updateInstructor(AdminDto adminDto){
        adminMapper.updateInstructor(adminDto);
    }

    @Override
    public AdminDto queryInstructorById(int id) {
        return adminMapper.queryInstructorById(id);
    }

    @Override
    public int getClassIdByUsername(String username){
        return adminMapper.getClassIdByUsername(username);
    }

    @Override
    public AdminDto showInstructorHimself(int id) {
        return adminMapper.showInstructorHimself(id);
    }

    @Override
    public void editInstructorHimself(Admin admin, String username, String password, String name) {
        adminMapper.editInstructorHimself(admin, username, MD5Util.md5(password), name);
    }
}
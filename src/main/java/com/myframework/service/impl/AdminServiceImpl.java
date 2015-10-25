package com.myframework.service.impl;

import com.myframework.dto.AdminDto;
import com.myframework.entity.Admin;
import com.myframework.mapper.AdminMapper;
import com.myframework.service.AdminService;
import com.myframework.util.MD5Util;
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
    public List<Admin> listAdmin(@Param("keywords") String keywords, @Param("id") int id){
        return adminMapper.listAdmin(keywords, id);
    }

    @Override
    public void insertAdmin(@Param("admin") Admin admin){
        admin.setPassword(MD5Util.md5(admin.getUsername()));
        adminMapper.insertAdmin(admin);
    }

    @Override
    public void delete(@Param("id") int id)  {
        adminMapper.delete(id);
    }

    @Override
    public Admin queryById(@Param("id") int id) {
        return adminMapper.queryById(id);
    }

    @Override
    public void update(@Param("admin") Admin admin){
        adminMapper.update(admin);
    }

    @Override
    public int checkLogin(@Param("admin") Admin admin){
        admin.setPassword(MD5Util.md5(admin.getPassword()));
        return adminMapper.checkLogin(admin.getUsername(), admin.getPassword());
    }

    @Override
    public Admin showHimself(@Param("id") int id) {
        return adminMapper.showHimself(id);
    }

    @Override
    public void editHimself(@Param("admin") Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name) {
        adminMapper.editHimself(admin, username, MD5Util.md5(password), name);
    }

    @Override
    public int getIdByUsername(@Param("admin") Admin admin){
        return adminMapper.getIdByUsername(admin.getUsername());
    }


    @Override
    public List<AdminDto> listInstructor(@Param("keywords") String keywords, @Param("id") int id, @Param("classId") int classId){
        return adminMapper.listInstructor(keywords, id, classId);
    }

    @Override
    public void insertInstructor(@Param("adminDto") AdminDto adminDto){
        adminDto.setPassword(MD5Util.md5(adminDto.getUsername()));
        adminMapper.insertInstructor(adminDto);
    }

    @Override
    public void updateInstructor(@Param("adminDto") AdminDto adminDto){
        adminMapper.updateInstructor(adminDto);
    }

    @Override
    public AdminDto queryInstructorById(@Param("id") int id) {
        return adminMapper.queryInstructorById(id);
    }
}

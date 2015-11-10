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
    public List<Admin> listAdmin(String keywords, @Param("id") int id) throws Exception{
        try {
            return adminMapper.listAdmin(keywords, id);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insertAdmin(Admin admin) throws Exception{
        try {
            if (admin.getUsername() == null || admin.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (admin.getPassword() == null || admin.getPassword() == "") {
                throw new Exception("密码不可为空");
            }
            if (admin.getName() == null || admin.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            //TODO: 判断用户名是否存在
            admin.setPassword(MD5Util.md5(admin.getUsername()));
            adminMapper.insertAdmin(admin);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            adminMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Admin queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return adminMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(Admin admin) throws Exception{
        try {
            if (admin.getUsername() == null || admin.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (admin.getPassword() == null || admin.getPassword() == "") {
                throw new Exception("密码不可为空");
            }
            if (admin.getName() == null || admin.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            //TODO: 判断用户名是否存在
            adminMapper.update(admin);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public int checkRole(Admin admin) throws Exception{
        try {
            return adminMapper.checkRole(admin.getUsername(), MD5Util.md5(admin.getPassword()));
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public Admin showHimself(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return adminMapper.showHimself(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void editHimself(Admin admin, @Param("username")String username, @Param("password")String password, @Param("name")String name) throws Exception{
        try {
            if (admin.getUsername() == null || admin.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (admin.getName() == null || admin.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            //TODO: 判断用户名是否存在
            adminMapper.editHimself(admin, username, MD5Util.md5(password), name);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public int getIdByUsername(String username) throws Exception{
        try {
            return adminMapper.getIdByUsername(username);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public List<AdminDto> listInstructor(int classId, @Param("keywords") String keywords) throws Exception{
        try {
            return adminMapper.listInstructor(classId, keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insertInstructor(AdminDto adminDto) throws Exception{
        try {
            if (adminDto.getUsername() == null || adminDto.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (adminDto.getPassword() == null || adminDto.getPassword() == "") {
                throw new Exception("密码不可为空");
            }
            if (adminDto.getName() == null || adminDto.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            if (adminDto.getClassName() == null || adminDto.getClassName() == "") {
                throw new Exception("所属班级不可为空");
            }
            if (adminDto.getDepartmentName() == null || adminDto.getDepartmentName() == "") {
                throw new Exception("所属系不可为空");
            }
            if (adminDto.getSchoolName() == null || adminDto.getSchoolName() == "") {
                throw new Exception("所属学院不可为空");
            }
            //TODO: 判断用户名是否存在
            //TODO: 判断所属班级是否存在
            //TODO: 判断所属系是否存在
            //TODO: 判断所属学院是否存在
            adminDto.setPassword(MD5Util.md5(adminDto.getPassword()));
            adminMapper.insertInstructor(adminDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void updateInstructor(AdminDto adminDto) throws Exception{
        try {
            if (adminDto.getUsername() == null || adminDto.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (adminDto.getName() == null || adminDto.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            if (adminDto.getClassName() == null || adminDto.getClassName() == "") {
                throw new Exception("所属班级不可为空");
            }
            if (adminDto.getDepartmentName() == null || adminDto.getDepartmentName() == "") {
                throw new Exception("所属系不可为空");
            }
            if (adminDto.getSchoolName() == null || adminDto.getSchoolName() == "") {
                throw new Exception("所属学院不可为空");
            }
            //TODO: 判断用户名是否存在
            //TODO: 判断所属班级是否存在
            //TODO: 判断所属系是否存在
            //TODO: 判断所属学院是否存在
            adminMapper.updateInstructor(adminDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public AdminDto queryInstructorById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return adminMapper.queryInstructorById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public int getClassIdByUsername(String username) throws Exception{
        try {
            if (username.equals("") || username == null) {
                throw new Exception("ID不合法");
            }
            return adminMapper.getClassIdByUsername(username);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public AdminDto showInstructorHimself(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return adminMapper.showInstructorHimself(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void editInstructorHimself(Admin admin, String username, String password, String name) throws Exception{
        try {
            if (admin.getUsername() == null || admin.getUsername() == "") {
                throw new Exception("用户名不可为空");
            }
            if (admin.getName() == null || admin.getName() == "") {
                throw new Exception("姓名不可为空");
            }
            //TODO: 判断用户名是否存在
            adminMapper.editInstructorHimself(admin, username, MD5Util.md5(password), name);
        } catch (Exception e){
            throw e;
        }
    }
}
package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.service.StudentService;
import com.houseyoung.student.util.MD5Util;
import com.houseyoung.student.mapper.StudentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:43.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<StudentDto> listStudent(int classId, String keywords) throws Exception{
        try {
            return studentMapper.listStudent(classId, keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(StudentDto studentDto) throws Exception{
        try {
            if (studentDto.getStudentId() == null || studentDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            if (studentDto.getStudentName() == null || studentDto.getStudentName() == "") {
                throw new Exception("姓名不可为空");
            }
            if (studentDto.getSex() == null || studentDto.getSex() == "") {
                throw new Exception("性别不可为空");
            }
            if (studentDto.getClassesName() == null || studentDto.getClassesName() == "") {
                throw new Exception("所属班级不可为空");
            }
            if (studentDto.getDepartmentName() == null || studentDto.getDepartmentName() == "") {
                throw new Exception("所属系不可为空");
            }
            if (studentDto.getSchoolName() == null || studentDto.getSchoolName() == "") {
                throw new Exception("所属学院不可为空");
            }
            //TODO: 判断性别是否合法
            //TODO: 判断所属班级是否存在
            //TODO: 判断所属系是否存在
            //TODO: 判断所属学院是否存在
            studentDto.setPassword(MD5Util.md5(studentDto.getStudentId()));
            studentMapper.insert(studentDto);
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
            studentMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public StudentDto queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return studentMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(StudentDto studentDto) throws Exception{
        try {
            if (studentDto.getStudentId() == null || studentDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            if (studentDto.getStudentName() == null || studentDto.getStudentName() == "") {
                throw new Exception("姓名不可为空");
            }
            if (studentDto.getSex() == null || studentDto.getSex() == "") {
                throw new Exception("性别不可为空");
            }
            if (studentDto.getClassesName() == null || studentDto.getClassesName() == "") {
                throw new Exception("所属班级不可为空");
            }
            if (studentDto.getDepartmentName() == null || studentDto.getDepartmentName() == "") {
                throw new Exception("所属系不可为空");
            }
            if (studentDto.getSchoolName() == null || studentDto.getSchoolName() == "") {
                throw new Exception("所属学院不可为空");
            }
            //TODO: 判断性别是否合法
            //TODO: 判断所属班级是否存在
            //TODO: 判断所属系是否存在
            //TODO: 判断所属学院是否存在
            studentMapper.update(studentDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public StudentDto showHimself(String studentId) throws Exception{
        try {
            if (studentId.equals("") || studentId == null) {
                throw new Exception("ID不合法");
            }
            return studentMapper.showHimself(studentId);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public int checkLogin(StudentDto studentDto) throws Exception{
        try {
            studentDto.setPassword(MD5Util.md5(studentDto.getPassword()));
            return studentMapper.checkLogin(studentDto.getStudentId(), studentDto.getPassword());
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void editPassword(StudentDto studentDto, @Param("password")String password) throws Exception{
        try {
            studentMapper.editPassword(studentDto, MD5Util.md5(password));
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void editInterest(StudentDto studentDto, @Param("interest")String interest) throws Exception{
        try {
            studentMapper.editInterest(studentDto, interest);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }
}
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
    public List<StudentDto> listStudent(int classId, String keywords){
        return studentMapper.listStudent(classId, keywords);
    }

    @Override
    public void insert(StudentDto studentDto){
        studentDto.setPassword(MD5Util.md5(studentDto.getStudentId()));
        studentMapper.insert(studentDto);
    }

    @Override
    public void delete(int id)  {
        studentMapper.delete(id);
    }

    @Override
    public StudentDto queryById(int id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void update(StudentDto studentDto){
        studentMapper.update(studentDto);
    }

    @Override
    public StudentDto showHimself(String studentId) {
        return studentMapper.showHimself(studentId);
    }

    @Override
    public int checkLogin(StudentDto studentDto){
        studentDto.setPassword(MD5Util.md5(studentDto.getPassword()));
        return studentMapper.checkLogin(studentDto.getStudentId(), studentDto.getPassword());
    }

    @Override
    public void editPassword(StudentDto studentDto, @Param("password")String password) {
        studentMapper.editPassword(studentDto, MD5Util.md5(password));
    }

    @Override
    public void editInterest(StudentDto studentDto, @Param("interest")String interest) {
        studentMapper.editInterest(studentDto, interest);
    }
}

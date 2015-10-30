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
    public List<StudentDto> listStudent(@Param("classId") int classId, @Param("keywords") String keywords){
        return studentMapper.listStudent(classId, keywords);
    }

    @Override
    public void insert(@Param("studentDto") StudentDto studentDto){
        studentDto.setPassword(MD5Util.md5(studentDto.getStudentId()));
        studentMapper.insert(studentDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        studentMapper.delete(id);
    }

    @Override
    public StudentDto queryById(@Param("id") int id) {
        return studentMapper.queryById(id);
    }

    @Override
    public void update(@Param("studentDto") StudentDto studentDto){
        studentMapper.update(studentDto);
    }

    @Override
    public StudentDto showHimself(@Param("studentId") String studentId) {
        return studentMapper.showHimself(studentId);
    }

    @Override
    public int checkLogin(@Param("studentDto") StudentDto studentDto){
        studentDto.setPassword(MD5Util.md5(studentDto.getPassword()));
        return studentMapper.checkLogin(studentDto.getStudentId(), studentDto.getPassword());
    }

    @Override
    public void editPassword(@Param("studentDto") StudentDto studentDto, @Param("password")String password) {
        studentMapper.editPassword(studentDto, MD5Util.md5(password));
    }

    @Override
    public void editInterest(@Param("studentDto") StudentDto studentDto, @Param("interest")String interest) {
        studentMapper.editInterest(studentDto, interest);
    }
}

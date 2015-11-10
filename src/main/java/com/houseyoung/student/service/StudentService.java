package com.houseyoung.student.service;

import com.houseyoung.student.dto.StudentDto;
import com.houseyoung.student.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:42.
 */
public interface StudentService {
    public List<StudentDto> listStudent(int classId, String keywords) throws Exception;

    public void insert(StudentDto studentDto) throws Exception;

    public void delete(int id) throws Exception;

    public StudentDto queryById(int id) throws Exception;

    public void update(StudentDto studentDto) throws Exception;

    public StudentDto showHimself(String studentId) throws Exception;

    public int checkLogin(StudentDto studentDto) throws Exception;

    public void editPassword(StudentDto studentDto, String password) throws Exception;

    public void editInterest(StudentDto studentDto, String interest) throws Exception;
}

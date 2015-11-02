package com.houseyoung.student.service;

import com.houseyoung.student.dto.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:42.
 */
public interface StudentService {
    public List<StudentDto> listStudent(int classId, String keywords);

    public void insert(StudentDto studentDto);

    public void delete(int id);

    public StudentDto queryById(int id);

    public void update(StudentDto studentDto);

    public StudentDto showHimself(String studentId);

    public int checkLogin(StudentDto studentDto);

    public void editPassword(StudentDto studentDto, String password);

    public void editInterest(StudentDto studentDto, String interest);
}

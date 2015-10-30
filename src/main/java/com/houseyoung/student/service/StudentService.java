package com.houseyoung.student.service;

import com.houseyoung.student.dto.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:42.
 */
public interface StudentService {
    public List<StudentDto> listStudent(@Param("classId") int classId, @Param("keywords") String keywords);

    public void insert(@Param("studentDto") StudentDto studentDto);

    public void delete(@Param("id") int id);

    public StudentDto queryById(@Param("id") int id);

    public void update(@Param("studentDto") StudentDto studentDto);

    public StudentDto showHimself(@Param("studentId") String studentId);

    public int checkLogin(@Param("studentDto") StudentDto studentDto);

    public void editPassword(@Param("studentDto") StudentDto studentDto, @Param("password")String password);

    public void editInterest(@Param("studentDto") StudentDto studentDto, @Param("interest")String interest);
}

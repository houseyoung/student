package com.houseyoung.student.mapper;

import com.houseyoung.student.dto.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:44.
 */
public interface StudentMapper {
    public List<StudentDto> listStudent(@Param("classId") int classId, @Param("keywords") String keywords) throws Exception;

    public void insert(@Param("studentDto") StudentDto studentDto) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public StudentDto queryById(@Param("id") int id) throws Exception;

    public void update(@Param("studentDto") StudentDto studentDto) throws Exception;

    public StudentDto showHimself(@Param("studentId") String studentId) throws Exception;

    public int checkLogin(@Param("studentId")String studentId, @Param("password")String password) throws Exception;

    public void editPassword(@Param("studentDto") StudentDto studentDto, @Param("password")String password) throws Exception;

    public void editInterest(@Param("studentDto") StudentDto studentDto, @Param("interest")String interest) throws Exception;
}

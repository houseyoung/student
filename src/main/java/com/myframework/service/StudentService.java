package com.myframework.service;

import com.myframework.dto.StudentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 20:42.
 */
public interface StudentService {
    public List<StudentDto> listStudent(@Param("keywords") String keywords);

    public void insert(@Param("studentDto") StudentDto studentDto);

    public void delete(@Param("id") int id);

    public StudentDto queryById(@Param("id") int id);

    public void update(@Param("studentDto") StudentDto studentDto);
}

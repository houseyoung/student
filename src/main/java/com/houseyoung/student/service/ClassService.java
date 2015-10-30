package com.houseyoung.student.service;

import com.houseyoung.student.dto.ClassDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:40.
 */
public interface ClassService {
    public List<ClassDto> listClass(@Param("classId") int classId, @Param("keywords") String keywords);

    public void insert(@Param("classDto") ClassDto classDto);

    public void delete(@Param("id") int id);

    public ClassDto queryById(@Param("id") int id);

    public void update(@Param("classDto") ClassDto classDto);
}

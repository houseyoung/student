package com.houseyoung.student.mapper;

import com.houseyoung.student.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 21:30.
 */
public interface SchoolMapper {
    public List<School> listSchool(@Param("keywords") String keywords) throws Exception;

    public void insert(@Param("school") School school) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public School queryById(@Param("id") int id) throws Exception;

    public void update(@Param("school") School school) throws Exception;
}

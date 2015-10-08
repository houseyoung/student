package com.myframework.service;

import com.myframework.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 21:29.
 */
public interface SchoolService {
    public List<School> listSchool(@Param("keywords") String keywords);

    public void insert(@Param("school") School school);

    public void delete(@Param("id") int id);

    public School queryById(@Param("id") int id);

    public void update(@Param("school") School school);
}

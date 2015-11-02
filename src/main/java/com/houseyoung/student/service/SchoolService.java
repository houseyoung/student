package com.houseyoung.student.service;

import com.houseyoung.student.entity.School;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 21:29.
 */
public interface SchoolService {
    public List<School> listSchool(String keywords) throws Exception;

    public void insert(School school) throws Exception;

    public void delete(int id) throws Exception;

    public School queryById(int id) throws Exception;

    public void update(School school) throws Exception;
}

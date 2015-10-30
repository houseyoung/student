package com.houseyoung.student.service.impl;

import com.houseyoung.student.entity.School;
import com.houseyoung.student.mapper.SchoolMapper;
import com.houseyoung.student.service.SchoolService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 21:31.
 */
@Service("schoolService")
public class SchoolServiceImpl implements SchoolService{
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> listSchool(@Param("keywords") String keywords){
        return schoolMapper.listSchool(keywords);
    }

    @Override
    public void insert(@Param("school") School school){
        schoolMapper.insert(school);
    }

    @Override
    public void delete(@Param("id") int id)  {
        schoolMapper.delete(id);
    }

    @Override
    public School queryById(@Param("id") int id) {
        return schoolMapper.queryById(id);
    }

    @Override
    public void update(@Param("school") School school){
        schoolMapper.update(school);
    }
}

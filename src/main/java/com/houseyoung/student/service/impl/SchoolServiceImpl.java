package com.houseyoung.student.service.impl;

import com.houseyoung.student.entity.School;
import com.houseyoung.student.mapper.SchoolMapper;
import com.houseyoung.student.service.SchoolService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
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
    public List<School> listSchool(String keywords) throws Exception{
        try {
            return schoolMapper.listSchool(keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(School school) throws Exception{
        try {
            if (school.getName() == null || school.getName() == ""){
                throw new Exception("学院名不可为空");
            }
            //TODO: 判断是否重名
            schoolMapper.insert(school);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            if (id <= 0){
                throw new Exception("ID不合法");
            }
            schoolMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public School queryById(int id) throws Exception{
        try {
            if (id <= 0){
                throw new Exception("ID不合法");
            }
            return schoolMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(School school) throws Exception{
        try {
            if (school.getName() == null || school.getName() == ""){
                throw new Exception("学院名不可为空");
            }
            //TODO: 判断是否重名
            schoolMapper.update(school);
        } catch (Exception e){
            throw e;
        }
    }
}

package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.HealthDto;
import com.houseyoung.student.mapper.HealthMapper;
import com.houseyoung.student.service.HealthService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:07.
 */
@Service("healthService")
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthMapper healthMapper;

    @Override
    public List<HealthDto> listHealth(@Param("classId") int classId, @Param("keywords") String keywords){
        return healthMapper.listHealth(classId, keywords);
    }

    @Override
    public void insert(@Param("healthDto") HealthDto healthDto){
        healthMapper.insert(healthDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        healthMapper.delete(id);
    }

    @Override
    public HealthDto queryById(@Param("id") int id) {
        return healthMapper.queryById(id);
    }

    @Override
    public void update(@Param("healthDto") HealthDto healthDto){
        healthMapper.update(healthDto);
    }

    @Override
    public List<HealthDto> listHimself(@Param("studentId") String studentId) {
        return healthMapper.listHimself(studentId);
    }
}

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
    public List<HealthDto> listHealth(int classId, String keywords) throws Exception{
        try {
            return healthMapper.listHealth(classId, keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(HealthDto healthDto) throws Exception{
        try {
            if (healthDto.getStudentId() == null || healthDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            //TODO: 判断学号是否存在
            healthMapper.insert(healthDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            healthMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public HealthDto queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return healthMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(HealthDto healthDto) throws Exception{
        try {
            if (healthDto.getStudentId() == null || healthDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            //TODO: 判断学号是否存在
            healthMapper.update(healthDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<HealthDto> listHimself(String studentId) throws Exception{
        try {
            return healthMapper.listHimself(studentId);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }
}

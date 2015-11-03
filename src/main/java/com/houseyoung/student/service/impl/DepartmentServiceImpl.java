package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.DepartmentDto;
import com.houseyoung.student.mapper.DepartmentMapper;
import com.houseyoung.student.service.DepartmentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 22:32.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDto> listDepartment(String keywords) throws Exception{
        try {
            return departmentMapper.listDepartment(keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(DepartmentDto departmentDto) throws Exception{
        try {
            if (departmentDto.getDepartmentName() == null || departmentDto.getDepartmentName() == "") {
                throw new Exception("系名不可为空");
            }
            //TODO: 判断学院是否存在
            departmentMapper.insert(departmentDto);
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
            departmentMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public DepartmentDto queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return departmentMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(DepartmentDto departmentDto) throws Exception{
        try {
            if (departmentDto.getDepartmentName() == null || departmentDto.getDepartmentName() == "") {
                throw new Exception("系名不可为空");
            }
            //TODO: 判断学院是否存在
            departmentMapper.update(departmentDto);
        } catch (Exception e){
            throw e;
        }
    }
}

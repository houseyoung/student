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
    public List<DepartmentDto> listDepartment(@Param("keywords") String keywords){
        return departmentMapper.listDepartment(keywords);
    }

    @Override
    public void insert(@Param("departmentDto") DepartmentDto departmentDto){
        departmentMapper.insert(departmentDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        departmentMapper.delete(id);
    }

    @Override
    public DepartmentDto queryById(@Param("id") int id) {
        return departmentMapper.queryById(id);
    }

    @Override
    public void update(@Param("departmentDto") DepartmentDto departmentDto){
        departmentMapper.update(departmentDto);
    }
}

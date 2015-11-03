package com.houseyoung.student.service;

import com.houseyoung.student.dto.DepartmentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 22:29.
 */
public interface DepartmentService {
    public List<DepartmentDto> listDepartment(String keywords) throws Exception;

    public void insert(DepartmentDto departmentDto) throws Exception;

    public void delete(int id) throws Exception;

    public DepartmentDto queryById(int id) throws Exception;

    public void update(DepartmentDto departmentDto) throws Exception;
}

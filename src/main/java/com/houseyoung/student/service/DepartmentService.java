package com.houseyoung.student.service;

import com.houseyoung.student.dto.DepartmentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 22:29.
 */
public interface DepartmentService {
    public List<DepartmentDto> listDepartment(String keywords);

    public void insert(DepartmentDto departmentDto);

    public void delete(int id);

    public DepartmentDto queryById(int id);

    public void update(DepartmentDto departmentDto);
}

package com.houseyoung.student.mapper;

import com.houseyoung.student.dto.DepartmentDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/8 22:32.
 */
public interface DepartmentMapper {
    public List<DepartmentDto> listDepartment(@Param("keywords") String keywords) throws Exception;

    public void insert(@Param("departmentDto") DepartmentDto departmentDto) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public DepartmentDto queryById(@Param("id") int id) throws Exception;

    public void update(@Param("departmentDto") DepartmentDto departmentDto) throws Exception;
}

package com.houseyoung.student.mapper;

import com.houseyoung.student.dto.HealthDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:06.
 */
public interface HealthMapper {
    public List<HealthDto> listHealth(@Param("classId") int classId, @Param("keywords") String keywords) throws Exception;

    public void insert(@Param("healthDto") HealthDto healthDto) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public HealthDto queryById(@Param("id") int id) throws Exception;

    public void update(@Param("healthDto") HealthDto healthDto) throws Exception;

    public List<HealthDto> listHimself(@Param("studentId") String studentId) throws Exception;
}

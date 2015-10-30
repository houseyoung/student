package com.houseyoung.student.service;

import com.houseyoung.student.dto.HealthDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:05.
 */
public interface HealthService {
    public List<HealthDto> listHealth(@Param("classId") int classId, @Param("keywords") String keywords);

    public void insert(@Param("healthDto") HealthDto healthDto);

    public void delete(@Param("id") int id);

    public HealthDto queryById(@Param("id") int id);

    public void update(@Param("healthDto") HealthDto healthDto);

    public List<HealthDto> listHimself(@Param("studentId") String studentId);
}

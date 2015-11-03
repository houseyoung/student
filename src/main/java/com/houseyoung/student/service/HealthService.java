package com.houseyoung.student.service;

import com.houseyoung.student.dto.HealthDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:05.
 */
public interface HealthService {
    public List<HealthDto> listHealth(int classId, String keywords) throws Exception;

    public void insert(HealthDto healthDto) throws Exception;

    public void delete(int id) throws Exception;

    public HealthDto queryById(int id) throws Exception;

    public void update(HealthDto healthDto) throws Exception;

    public List<HealthDto> listHimself(String studentId) throws Exception;
}

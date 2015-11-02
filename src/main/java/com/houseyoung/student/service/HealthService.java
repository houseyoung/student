package com.houseyoung.student.service;

import com.houseyoung.student.dto.HealthDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/11 23:05.
 */
public interface HealthService {
    public List<HealthDto> listHealth(int classId, String keywords);

    public void insert(HealthDto healthDto);

    public void delete(int id);

    public HealthDto queryById(int id);

    public void update(HealthDto healthDto);

    public List<HealthDto> listHimself(String studentId);
}

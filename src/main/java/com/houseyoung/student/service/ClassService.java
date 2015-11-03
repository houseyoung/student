package com.houseyoung.student.service;

import com.houseyoung.student.dto.ClassDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:40.
 */
public interface ClassService {
    public List<ClassDto> listClass(int classId, String keywords) throws Exception;

    public void insert(ClassDto classDto) throws Exception;

    public void delete(int id) throws Exception;

    public ClassDto queryById(int id) throws Exception;

    public void update(ClassDto classDto) throws Exception;
}

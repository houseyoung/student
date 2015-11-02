package com.houseyoung.student.service;

import com.houseyoung.student.dto.ClassDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:40.
 */
public interface ClassService {
    public List<ClassDto> listClass(int classId, String keywords);

    public void insert(ClassDto classDto);

    public void delete(int id);

    public ClassDto queryById(int id);

    public void update(ClassDto classDto);
}

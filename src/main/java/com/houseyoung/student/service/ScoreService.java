package com.houseyoung.student.service;

import com.houseyoung.student.dto.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:40.
 */
public interface ScoreService {
    public List<ScoreDto> listScore(@Param("classId") int classId, @Param("studentId") String studentId, @Param("courseName") String courseName);

    public void insert(@Param("scoreDto") ScoreDto scoreDto);

    public void delete(@Param("id") int id);

    public ScoreDto queryById(@Param("id") int id);

    public void update(@Param("scoreDto") ScoreDto scoreDto);

    public List<ScoreDto> listHimself(@Param("studentId") String studentId);
}
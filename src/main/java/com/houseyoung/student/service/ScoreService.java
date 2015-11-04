package com.houseyoung.student.service;

import com.houseyoung.student.dto.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:40.
 */
public interface ScoreService {
    public List<ScoreDto> listScore(int classId, String studentId, String courseName) throws Exception;

    public void insert(ScoreDto scoreDto) throws Exception;

    public void delete(int id) throws Exception;

    public ScoreDto queryById(int id) throws Exception;

    public void update(ScoreDto scoreDto) throws Exception;

    public List<ScoreDto> listHimself(String studentId) throws Exception;
}

package com.houseyoung.student.service;

import com.houseyoung.student.dto.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:40.
 */
public interface ScoreService {
    public List<ScoreDto> listScore(int classId, String studentId, String courseName);

    public void insert(ScoreDto scoreDto);

    public void delete(int id);

    public ScoreDto queryById(int id);

    public void update(ScoreDto scoreDto);

    public List<ScoreDto> listHimself(String studentId);
}

package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.ScoreDto;
import com.houseyoung.student.mapper.ScoreMapper;
import com.houseyoung.student.service.ScoreService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:41.
 */
@Service("scoreService")
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public List<ScoreDto> listScore(int classId, String studentId, String courseName){
        return scoreMapper.listScore(classId, studentId, courseName);
    }

    @Override
    public void insert(ScoreDto scoreDto){
        scoreMapper.insert(scoreDto);
    }

    @Override
    public void delete(int id)  {
        scoreMapper.delete(id);
    }

    @Override
    public ScoreDto queryById(int id) {
        return scoreMapper.queryById(id);
    }

    @Override
    public void update(ScoreDto scoreDto){
        scoreMapper.update(scoreDto);
    }

    @Override
    public List<ScoreDto> listHimself(String studentId) {
        return scoreMapper.listHimself(studentId);
    }

}

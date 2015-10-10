package com.myframework.service.impl;

import com.myframework.dto.ScoreDto;
import com.myframework.mapper.ScoreMapper;
import com.myframework.service.ScoreService;
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
    public List<ScoreDto> listScore(@Param("keywords") String keywords){
        return scoreMapper.listScore(keywords);
    }

    @Override
    public void insert(@Param("scoreDto") ScoreDto scoreDto){
        scoreMapper.insert(scoreDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        scoreMapper.delete(id);
    }

    @Override
    public ScoreDto queryById(@Param("id") int id) {
        return scoreMapper.queryById(id);
    }

    @Override
    public void update(@Param("scoreDto") ScoreDto scoreDto){
        scoreMapper.update(scoreDto);
    }

    @Override
    public List<ScoreDto> listHimself(@Param("studentId") String studentId) {
        return scoreMapper.listHimself(studentId);
    }

}

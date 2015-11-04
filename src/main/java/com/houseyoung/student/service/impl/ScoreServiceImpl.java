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
    public List<ScoreDto> listScore(int classId, String studentId, String courseName) throws Exception{
        try {
            return scoreMapper.listScore(classId, studentId, courseName);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(ScoreDto scoreDto) throws Exception{
        try {
            if (scoreDto.getStudentId() == null || scoreDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            if (scoreDto.getCourseId() == null || scoreDto.getCourseId() == "") {
                throw new Exception("课程编号不可为空");
            }
            //TODO: 判断学号是否存在
            //TODO: 判断课程编号是否存在
            scoreMapper.insert(scoreDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            scoreMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public ScoreDto queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return scoreMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(ScoreDto scoreDto) throws Exception{
        try {
            if (scoreDto.getStudentId() == null || scoreDto.getStudentId() == "") {
                throw new Exception("学号不可为空");
            }
            if (scoreDto.getCourseId() == null || scoreDto.getCourseId() == "") {
                throw new Exception("课程编号不可为空");
            }
            //TODO: 判断学号是否存在
            //TODO: 判断课程编号是否存在
            scoreMapper.update(scoreDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<ScoreDto> listHimself(String studentId) throws Exception{
        try {
            return scoreMapper.listHimself(studentId);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }
}

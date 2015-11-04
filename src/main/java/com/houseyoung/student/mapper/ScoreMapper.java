package com.houseyoung.student.mapper;

import com.houseyoung.student.dto.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:42.
 */
public interface ScoreMapper {
    public List<ScoreDto> listScore(@Param("classId") int classId, @Param("studentId") String studentId, @Param("courseName") String courseName) throws Exception;

    public void insert(@Param("scoreDto") ScoreDto scoreDto) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public ScoreDto queryById(@Param("id") int id) throws Exception;

    public void update(@Param("scoreDto") ScoreDto scoreDto) throws Exception;

    public List<ScoreDto> listHimself(@Param("studentId") String studentId) throws Exception;
}

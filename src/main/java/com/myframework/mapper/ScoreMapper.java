package com.myframework.mapper;

import com.myframework.dto.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 15/10/10 22:42.
 */
public interface ScoreMapper {
    public List<ScoreDto> listScore(@Param("keywords") String keywords);

    public void insert(@Param("scoreDto") ScoreDto scoreDto);

    public void delete(@Param("id") int id);

    public ScoreDto queryById(@Param("id") int id);

    public void update(@Param("scoreDto") ScoreDto scoreDto);

    public List<ScoreDto> listHimself(@Param("studentId") String studentId);
}

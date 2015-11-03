package com.houseyoung.student.mapper;

import com.houseyoung.student.dto.ClassDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:42.
 */
public interface ClassMapper {
    public List<ClassDto> listClass(@Param("classId") int classId, @Param("keywords") String keywords) throws Exception;

    public void insert(@Param("classDto") ClassDto classDto) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public ClassDto queryById(@Param("id") int id) throws Exception;

    public void update(@Param("classDto") ClassDto classDto) throws Exception;
}

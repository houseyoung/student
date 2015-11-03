package com.houseyoung.student.mapper;

import com.houseyoung.student.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:45.
 */
public interface CourseMapper {
    public List<Course> listCourse(@Param("keywords") String keywords) throws Exception;

    public void insert(@Param("course") Course course) throws Exception;

    public void delete(@Param("id") int id) throws Exception;

    public Course queryById(@Param("id") int id) throws Exception;

    public void update(@Param("course") Course course) throws Exception;

    public List<Course> listHimself(@Param("studentId") String studentId) throws Exception;
}

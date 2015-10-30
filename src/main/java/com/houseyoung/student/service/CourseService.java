package com.houseyoung.student.service;

import com.houseyoung.student.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:44.
 */
public interface CourseService {
    public List<Course> listCourse(@Param("keywords") String keywords);

    public void insert(@Param("course") Course course);

    public void delete(@Param("id") int id);

    public Course queryById(@Param("id") int id);

    public void update(@Param("course") Course course);
}

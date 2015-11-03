package com.houseyoung.student.service;

import com.houseyoung.student.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:44.
 */
public interface CourseService {
    public List<Course> listCourse(String keywords) throws Exception;

    public void insert(Course course) throws Exception;

    public void delete(int id) throws Exception;

    public Course queryById(int id) throws Exception;

    public void update(Course course) throws Exception;

    public List<Course> listHimself(String studentId) throws Exception;
}

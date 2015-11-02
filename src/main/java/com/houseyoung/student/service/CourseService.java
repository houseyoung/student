package com.houseyoung.student.service;

import com.houseyoung.student.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:44.
 */
public interface CourseService {
    public List<Course> listCourse(String keywords);

    public void insert(Course course);

    public void delete(int id);

    public Course queryById(int id);

    public void update(Course course);

    public List<Course> listHimself(String studentId);
}

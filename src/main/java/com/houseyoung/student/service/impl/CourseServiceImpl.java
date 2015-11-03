package com.houseyoung.student.service.impl;

import com.houseyoung.student.entity.Course;
import com.houseyoung.student.mapper.CourseMapper;
import com.houseyoung.student.service.CourseService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 14:45.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> listCourse(String keywords){
        return courseMapper.listCourse(keywords);
    }

    @Override
    public void insert(Course course){
        courseMapper.insert(course);
    }

    @Override
    public void delete(int id)  {
        courseMapper.delete(id);
    }

    @Override
    public Course queryById(int id) {
        return courseMapper.queryById(id);
    }

    @Override
    public void update(Course course){
        courseMapper.update(course);
    }

    @Override
    public List<Course> listHimself(String studentId) {
        return courseMapper.listHimself(studentId);
    }
}

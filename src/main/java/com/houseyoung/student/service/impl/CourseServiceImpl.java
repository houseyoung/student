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
    public List<Course> listCourse(@Param("keywords") String keywords){
        return courseMapper.listCourse(keywords);
    }

    @Override
    public void insert(@Param("course") Course course){
        courseMapper.insert(course);
    }

    @Override
    public void delete(@Param("id") int id)  {
        courseMapper.delete(id);
    }

    @Override
    public Course queryById(@Param("id") int id) {
        return courseMapper.queryById(id);
    }

    @Override
    public void update(@Param("course") Course course){
        courseMapper.update(course);
    }

    @Override
    public List<Course> listHimself(@Param("studentId") String studentId) {
        return courseMapper.listHimself(studentId);
    }
}

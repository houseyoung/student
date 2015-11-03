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
    public List<Course> listCourse(String keywords) throws Exception{
        try {
            return courseMapper.listCourse(keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(Course course) throws Exception{
        try {
            if (course.getName() == null || course.getName() == "") {
                throw new Exception("课程名不可为空");
            }
            //TODO: 判断是否重名
            courseMapper.insert(course);
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
            courseMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public Course queryById(int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return courseMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(Course course) throws Exception{
        try {
            if (course.getName() == null || course.getName() == "") {
                throw new Exception("课程名不可为空");
            }
            //TODO: 判断是否重名
            courseMapper.update(course);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Course> listHimself(String studentId) throws Exception{
        try {
            return courseMapper.listHimself(studentId);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }
}

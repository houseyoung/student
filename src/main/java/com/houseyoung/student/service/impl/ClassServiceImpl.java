package com.houseyoung.student.service.impl;

import com.houseyoung.student.dto.ClassDto;
import com.houseyoung.student.mapper.ClassMapper;
import com.houseyoung.student.service.ClassService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houseyoung on 2015/10/9 8:41.
 */
@Service("classService")
public class ClassServiceImpl implements ClassService{
    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<ClassDto> listClass(@Param("classId") int classId, @Param("keywords") String keywords) throws Exception{
        try {
            return classMapper.listClass(classId, keywords);
        } catch (Exception e){
            throw new Exception("系统内部异常");
        }
    }

    @Override
    public void insert(@Param("classDto") ClassDto classDto) throws Exception{
        try {
            if (classDto.getClassName() == null || classDto.getClassName() == ""){
                throw new Exception("学院名不可为空");
            }
            //TODO: 判断系、学院是否存在
            classMapper.insert(classDto);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void delete(@Param("id") int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            classMapper.delete(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public ClassDto queryById(@Param("id") int id) throws Exception{
        try {
            if (id <= 0) {
                throw new Exception("ID不合法");
            }
            return classMapper.queryById(id);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(@Param("classDto") ClassDto classDto) throws Exception{
        try {
            if (classDto.getClassName() == null || classDto.getClassName() == "") {
                throw new Exception("学院名不可为空");
            }
            //TODO: 判断系、学院是否存在
            classMapper.update(classDto);
        } catch (Exception e){
            throw e;
        }
    }
}

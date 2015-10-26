package com.myframework.service.impl;

import com.myframework.dto.ClassDto;
import com.myframework.mapper.ClassMapper;
import com.myframework.service.ClassService;
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
    public List<ClassDto> listClass(@Param("classId") int classId, @Param("keywords") String keywords){
        return classMapper.listClass(classId, keywords);
    }

    @Override
    public void insert(@Param("classDto") ClassDto classDto){
        classMapper.insert(classDto);
    }

    @Override
    public void delete(@Param("id") int id)  {
        classMapper.delete(id);
    }

    @Override
    public ClassDto queryById(@Param("id") int id) {
        return classMapper.queryById(id);
    }

    @Override
    public void update(@Param("classDto") ClassDto classDto){
        classMapper.update(classDto);
    }
}

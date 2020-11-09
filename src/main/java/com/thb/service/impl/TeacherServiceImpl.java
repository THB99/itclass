package com.thb.service.impl;

import com.thb.domain.Cart;
import com.thb.domain.Teacher;
import com.thb.mapper.CartMapper;
import com.thb.mapper.TeacherMapper;
import com.thb.service.ICartService;
import com.thb.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAllteacher() {
        return teacherMapper.findAllteacher();
    }

    @Override
    public void add(Teacher teacher) {
        teacherMapper.addteacher(teacher);
    }
}

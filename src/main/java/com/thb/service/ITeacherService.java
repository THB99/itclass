package com.thb.service;

import com.thb.domain.ResultDTO;
import com.thb.domain.Teacher;
import com.thb.domain.User;

import java.util.List;

public interface ITeacherService {
    List<Teacher> findAllteacher();

    void add(Teacher teacher);
}

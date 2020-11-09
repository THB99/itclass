package com.thb.mapper;

import com.thb.domain.Lesson;
import com.thb.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface TeacherMapper {

   Teacher findById(int id);

   List<Teacher> findAllteacher();


   void addteacher(Teacher teacher);
}


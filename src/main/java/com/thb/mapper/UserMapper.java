package com.thb.mapper;

import com.thb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()
public interface UserMapper {

    User login(@Param(value = "username") String username, @Param(value = "password") String password);
}


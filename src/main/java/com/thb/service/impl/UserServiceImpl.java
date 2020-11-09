package com.thb.service.impl;

import com.thb.domain.ResultDTO;
import com.thb.domain.User;
import com.thb.mapper.UserMapper;
import com.thb.service.IUserService;
import com.thb.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultDTO<User> login1(String username, String password) {
        User user = userMapper.login(username, password);
        ResultDTO<User> resultDTO =null;
        if (user==null){
            resultDTO=ResultUtils.failResult(user,"手机号码或密码错误");
        }else {
            resultDTO=ResultUtils.successResult(user,"登陆成功");
        }
        System.out.println("resultDTO:"+resultDTO);
        return resultDTO;
    }

    @Override
    public User login(String username, String password) {
        User user = userMapper.login(username, password);
        return user;
    }
}

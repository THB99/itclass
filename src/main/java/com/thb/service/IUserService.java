package com.thb.service;

import com.thb.domain.ResultDTO;
import com.thb.domain.User;

import java.util.List;

public interface IUserService {
    public ResultDTO<User> login1(String username, String password);

    User login(String username, String password);
}

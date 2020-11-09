package com.thb.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import com.thb.domain.ResultDTO;
import com.thb.domain.User;
import com.thb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.US_ASCII;

import java.util.regex.PatternSyntaxException;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/login1")
    public ResultDTO login1(@RequestParam("name") String username, @RequestParam("password") String password){
        ResultDTO<User> resultDTO = userService.login1(username, password);
        return resultDTO;

    }
    @RequestMapping(value = "/login")
    public User login(@RequestParam("name") String username, @RequestParam("password") String password){
        User user = userService.login(username, password);
        if (user==null){
            User user1 = new User();
            user1.setId(0);
            return user1;
        }else {
            return user;
        }

    }
}


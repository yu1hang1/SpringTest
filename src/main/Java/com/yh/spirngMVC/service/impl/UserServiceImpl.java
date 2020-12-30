package com.yh.spirngMVC.service.impl;

import com.yh.spirngMVC.bean.User;
import com.yh.spirngMVC.dao.UserMapper;
import com.yh.spirngMVC.service.UserService;
import com.yh.spirngMVC.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @program: SpringTest
 * @description:
 * @author: yuhang
 * @create: 2019-07-12 15:13
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public Result UserRegister(String username, String password) {
        if (StringUtils.isEmpty(username.trim())||StringUtils.isEmpty(password.trim())) {
            return Result.error("用户名或者密码不能为空");
        }
        User user = userMapper.getUserByUsername(username);
        if (user != null){
            return Result.error("用户已存在");
        }
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userMapper.insertUser(newUser);
        return Result.success();
    }

    @Override
    public Result UserLogin(String username, String password) {
        if (StringUtils.isEmpty(username.trim())||StringUtils.isEmpty(password.trim())) {
            return Result.error("用户名或者密码不能为空");
        }
        User user = userMapper.getUserByUsername(username);
        if (user == null) {
            return Result.error("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            return Result.error("密码错误");
        }
        return Result.success();
    }
}

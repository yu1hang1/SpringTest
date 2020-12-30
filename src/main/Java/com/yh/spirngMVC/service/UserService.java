package com.yh.spirngMVC.service;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yh.spirngMVC.bean.User;
import com.yh.spirngMVC.utils.Result;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Result UserRegister(String username , String password);

    Result UserLogin(String username, String password);
}

package com.yh.spirngMVC.bean;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: SpringTest
 * @description:
 * @author: yuhang
 * @create: 2019-07-12 15:14
 **/

public class User implements Serializable {

    private static final long serialVersionUID = -5405397720344575349L;
    private String username;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    private String password;

    public String getUsername() {
        return username;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

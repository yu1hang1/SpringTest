package com.yh.spirngMVC.dao;


import com.yh.spirngMVC.bean.User;
import com.yh.spirngMVC.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User getUserByUsername(@Param("username") String username);

    void insertUser(User user);
}

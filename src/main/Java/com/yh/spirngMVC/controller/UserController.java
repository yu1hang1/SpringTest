package com.yh.spirngMVC.controller;

import com.google.common.collect.Lists;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.yh.spirngMVC.bean.User;
import com.yh.spirngMVC.service.UserService;
import com.yh.spirngMVC.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringTest
 * @description:
 * @author: yuhang
 * @create: 2019-07-12 15:02
 **/
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    @RequestBody 注解 用来将请求体的参数（Json数据） 绑定在对象上，也就是将Json数据转化为Java对象
    public Result register(@RequestBody User user) {
        return userService.UserRegister(user.getUsername(),user.getPassword());
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public Result login(@RequestBody User user){

        return userService.UserLogin(user.getUsername(),user.getPassword());
    }





    /**
     * 1、提交的域名和处理方法的参数一致时，可以直接从url中将值取出。
     * 2、请求方法为get或POST，参数放在url上，一次可以提取一个或多个
     * */
    @RequestMapping("hello")
    public String hello(String name){
        System.out.println(name);
        return "index.jsp";
    }

    /**
     * 1、提交的域名和处理方法不一致时，需要借助@RequestParam 进行提取。
     * 2、请求方法为get或POST，参数放在url上，一次可以提取一个或多个
     * 3、如果使用@RequestParam，url域参数名称必须和()里接收的参数名一致，否则会400*/
    @RequestMapping("hello1")
    public String hello1(@RequestParam("uname") String name ,@RequestParam("apassword") String password){
        System.out.println(name);
        System.out.println(password);
        return "index.jsp";
    }
    /**
     * 1、当提交的是一个对象的时候，可以再表单域名中提交表单
     * 2、注意的是，所提交的域名要和实体类的属性名一致，才能获取，否则取不到
     * 3、请求方法仍为get或POST，请求参数仍然放在url中*/
    @RequestMapping("hello2")
    public String hello2(User user){
        System.out.println("==================");
        System.out.println(user.getPassword());
        return "index.jsp";
    }
    /**
     * restful写法
     * 1、将请求参数放在url上
     * 2、请求方法为get，从url path 提取参数
     * 3、可以设置一个或多个*/
    @RequestMapping("hello3/{id}")
    public String hello3(@PathVariable int id){
        System.out.println(id);
        return "index.jsp";
    }
    /**
     * 用POST提交表单
     * 1、传递参数类型为Json，放在body中
     * 2、接收时需要@RequestBody注解  将其封装在实体类中
     * 3、Json数据类型可以构造列表的形式，但接受的实体类的属性也的为list对象
     * */
    @RequestMapping(value = "hello4",method = RequestMethod.POST)
    public String hello4(@RequestBody User user){
        System.out.println(user);
        return "index.jsp";
    }

    /**
     * 请求参数为list时，如何接收
     * 1、同样需要使用@RequestParam注解，只不过后面接受参数类型为List，
     * 2、请求方式为GET或POST，参数仍然在url，key为listParam ，value 为 1，2，3，4等
     * 3、需要注意的是，在用Postman发送请求时 列表不能加[]，否则会报400的错误
     * */
    @RequestMapping(value = "hello5")
    public String hello5(@RequestParam("listParam") List list){
        System.out.println(list);
        return "index.jsp";
    }

}

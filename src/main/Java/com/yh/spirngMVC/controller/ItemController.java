package com.yh.spirngMVC.controller;

import com.yh.spirngMVC.bean.Item;
import com.yh.spirngMVC.bean.User;
import com.yh.spirngMVC.service.ItemService;
import com.yh.spirngMVC.service.UserService;
import com.yh.spirngMVC.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class ItemController {
    @Autowired
    private ItemService itemService;


    /**
    * 显示商品列表*/
    @RequestMapping("/itemList/{name}")
    public ModelAndView queryItemList(@PathVariable("name") String name){
//        从request 请求中获取参数
//        获取商品数据
        List<Item> list = itemService.queryItemList(name);

        ModelAndView modelAndView  = new ModelAndView();

        modelAndView.addObject("item",list);




        modelAndView.setViewName("itemList");

        return modelAndView;

    }

}

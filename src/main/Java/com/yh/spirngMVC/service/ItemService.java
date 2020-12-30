package com.yh.spirngMVC.service;

import com.yh.spirngMVC.bean.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 查询商品列表*/
@Service
public interface ItemService {

    List<Item> queryItemList(String itemName);

}

package com.yh.spirngMVC.service.impl;

import com.yh.spirngMVC.bean.Item;
import com.yh.spirngMVC.dao.ItemMapper;
import com.yh.spirngMVC.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: SpringTest
 * @description:
 * @author: yuhang
 * @create: 2019-07-11 13:31
 **/

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemList(String itemName) {

        List<Item> list = itemMapper.getItemByItemname(itemName);

        return list;
    }
}

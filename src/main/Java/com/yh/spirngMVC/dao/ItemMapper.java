package com.yh.spirngMVC.dao;

import com.yh.spirngMVC.bean.Item;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
    List<Item> getItemByItemname(@Param("itemname") String itemname);

    void insertItem(Item item);
}

package com.example.cosmo_lab.item.model;

import com.example.cosmo_lab.item.dto.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ItemMapper {

    //상품 립품목만 가져오기
    @Select("SELECT * FROM item WHERE kind=2;")
    List<Item> getItemList();

    // 립 상품 상세 조회
    @Select("SELECT * FROM item WHERE PRODUCT_ID='${product_id}';")
    Item getItem(int product_id);

}

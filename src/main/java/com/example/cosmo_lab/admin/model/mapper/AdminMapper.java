package com.example.cosmo_lab.admin.model.mapper;

import com.example.cosmo_lab.admin.model.dto.AddItemDto;
import com.example.cosmo_lab.admin.model.dto.ItemListDto;
import com.example.cosmo_lab.admin.model.dto.ModifyItemDto;
import com.example.cosmo_lab.admin.model.dto.OrderDetail;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from Order join ")
    List<OrderDetail> getDeliveries();

    @Insert("insert into item(product_name, kind, price1, price2, price3, content, image, available) values(#{itemName}, #{category}, #{originalPrice}, #{sellingPrice}, #{profit}, #{itemDescription}, #{itemImage}, #{status})")
    int addItem(AddItemDto item);

    @Select("select product_id, kind, product_name, price1, price2, price3, available from item")
    List<ItemListDto> items();

    @Select("select product_id, kind, product_name, price1, price2, price3, available from item where kind=#{kind} and product_name like '%${product_name}%'")
    List<ItemListDto> searchItems(@Param("kind") int kind, @Param("product_name") String keyword);

    @Select("select product_id, kind, product_name, price1, price2, price3, available from item where product_name like '%${product_name}%'")
    List<ItemListDto> searchItemsByKeyword(@Param("product_name") String keyword);

    @Select("select product_id, kind, available, product_name, price2, image, content from item where product_id=#{productId}")
    ModifyItemDto modifyForm(@Param("productId") int productId);

    @Update("update item set product_name=#{productName}, kind=#{kind}, price2=#{price2}, content=#{content}, available=#{available} where product_id=#{productId}")
    int modifyItem(ModifyItemDto modifyItemDto);
}
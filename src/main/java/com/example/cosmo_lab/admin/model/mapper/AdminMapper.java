package com.example.cosmo_lab.admin.model.mapper;

import com.example.cosmo_lab.admin.model.dto.AddItemDto;
import com.example.cosmo_lab.admin.model.dto.ItemListDto;
import com.example.cosmo_lab.admin.model.dto.ModifyItemDto;
import com.example.cosmo_lab.admin.model.dto.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select * from Order join ")
    List<OrderDetail> getDeliveries();

    @Insert("insert into item(product_name, kind, price1, price2, price3, content, image, available) values(#{itemName}, #{category}, #{originalPrice}, #{sellingPrice}, #{profit}, #{itemDescription}, #{itemImage}, #{status})")
    int addItem(AddItemDto item);

    @Select("select product_id, kind, product_name, price1, price2, price3, available from item")
    List<ItemListDto> items();

    @Select("select product_id, kind, available, product_name, price2, image, content from item where product_id=#{productId}")
    ModifyItemDto modifyForm(@Param("productId") int productId);
}
package com.example.cosmo_lab.order.mapper;


import com.example.cosmo_lab.item.dto.Item;
import com.example.cosmo_lab.user.model.dao.UserDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderMapper {


    //상품 상세에서 주문내역 넘길때 (주문 상품 정보)
    @Select("SELECT * FROM item WHERE PRODUCT_ID='${product_id}';")
    Item getOrder(int product_id);



//   //주문 정보
    @Insert("INSERT INTO order('order_id','user_id','date','receiver','rec_address','rec_phone','result','process_date')"+
        "values('${order_id}','${user_id}','${date}','${receiver}','${rec_address}','${rec_phone}','${result}','${process_date}');")
     int insertOrder();


    //주문상세
    @Insert("INSERT INTO orderdetail('order_d_id','order_id','product_id','quantity')" +
            "valuse('${order_d_id}','${order_id}','${product_id}','${quantity}');")
    int OrderDetail();


    //주문 아이템 테이블
    @Insert("INSERT INTO item('product_id','product_name','kind','price1','price2','price3','content','image','available','best_yn','date'," +
            "values('${product_id}','${product_name}','${kind}','${price1}','${price2}','${price3}','${content}',${image},${available},'${best_yn}','${date}');")
    int inserItem();


}




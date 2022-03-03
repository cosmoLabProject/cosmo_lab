package com.example.cosmo_lab.user;

import com.example.cosmo_lab.user.model.dao.UserDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    //아이디로 회원번호 조회
    @Select("SELECT user_id FROM user WHERE ID='${id}';")
    Integer getUserID(String id);

    //주문자 정보 (회원번호)
    @Select("SELECT id,name,email,zipcode,address,phone FROM user WHERE USER_ID='${user_id}';")
    List<UserDao> getUser(Integer user_id);


}

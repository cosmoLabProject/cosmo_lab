package com.example.cosmo_lab.user.model.dao;

import com.example.cosmo_lab.user.domain.Cart;
import com.example.cosmo_lab.user.domain.Order;
import com.example.cosmo_lab.user.domain.Question;
import com.example.cosmo_lab.user.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    // ========== 회원가입 ==========
    @Insert("INSERT INTO USER (id, pw, name, nickname, email, zipcode, address, address_detail, phone) " +
            "VALUES ('${id}', '${pw}', '${name}', '${nickname}', '${email}', '${zipcode}', '${address}', '${address_detail}', '${phone}');")
    int createAccount(User user);

    // ========== 로그인 ==========
    @Select("SELECT * FROM USER WHERE ID='${id}' AND PW='${pw}';")
    User login(String id, String pw);

    // ========== 회원탈퇴 ==========
    @Update("UPDATE USER " +
            "SET PW='deleted', NAME='deleted', NICKNAME=NULL, EMAIL='deleted', " +
            "ZIPCODE='deleted', ADDRESS='deleted', ADDRESS_DETAIL='deleted', AVAILABLE='n' " +
            "WHERE USER_ID='${user_id}';")
    int deleteUser(int user_id);

    // ========== 회원탈퇴 사유 ==========
    @Insert("INSERT INTO USER (user_id, reason_code, reason_detail) " +
            "VALUES ('${user_id}', '${reason_code}', '${reason_detail}');")
    int reason(int user_id, int reason_code, String reason_detail);

    //  ========== 아이디로 회원 번호 조회 ==========
    @Select("SELECT user_id FROM USER WHERE ID='${id}';")
    int getUserID(String id);

    // ========== 회원번호로 비밀번호 조회 ==========
    @Select("SELECT pw FROM USER WHERE user_id='${user_id}';")
    String getPassword(int user_id);

    // ========== 장바구니 조회 ==========
    @Select("SELECT cart.user_id, cart.product_id, item.image, item.product_name, item.content, item.price2, cart.quantity " +
            "FROM CART as cart " +
            "left outer join ITEM as item " +
            "ON cart.product_id=item.product_id " +
            "WHERE user_id='${user_id}' " +
            "ORDER BY cart.date DESC;")
    List<Cart> cartList(int user_id);

    // ========== 장바구니 물건 개별 삭제 ==========
    @Delete("DELETE FROM CART WHERE USER_ID='${user_id}' AND PRODUCT_ID='${product_id}';")
    int deleteItem(int user_id, int product_id);

    // ========== 주문 내역 조회 ==========
    @Select("SELECT * FROM ORDERTBL WHERE user_id='${user_id}' ORDER BY date DESC;")
    List<Order> OrderList(int user_id);

    // ========== 문의 남기기 ==========
    @Insert("INSERT INTO QnA (user_id, subject, content) VALUES ('${user_id}', '${subject}', '${content}');")
    int addQuestion(int user_id, String subject, String content);

    // ========== 문의 내역 조회 ==========
    @Select("SELECT * FROM QnA WHERE user_id='${user_id}' ORDER BY write_date DESC;")
    List<Question> QuestionList(int user_id);

    /*
    //아이디로 회원번호 조회
    @Select("SELECT user_id FROM user WHERE ID='${id}';")
    Integer getUserID(String id);

 */
    //주문자 정보 (회원번호)
    @Select("SELECT id,name,email,zipcode,address,phone FROM user WHERE USER_ID='${user_id}';")
    List<UserDao> getUser(Integer user_id);

}

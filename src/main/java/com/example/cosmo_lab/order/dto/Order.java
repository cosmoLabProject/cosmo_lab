package com.example.cosmo_lab.order.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Order {

    private int order_id; //주문번호
    private int user_id; //회원번호
    private Date datetime;      //주문일
    private String receiver; //수령인
    private String rec_address; //수령주소
    private String rec_phone; //수령인 전화번호
    private String result; //처리여부
    private Date process_date; //처리일시

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getRec_address() {
        return rec_address;
    }

    public void setRec_address(String rec_address) {
        this.rec_address = rec_address;
    }

    public String getRec_phone() {
        return rec_phone;
    }

    public void setRec_phone(String rec_phone) {
        this.rec_phone = rec_phone;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getProcess_date() {
        return process_date;
    }

    public void setProcess_date(Date process_date) {
        this.process_date = process_date;
    }
}

package com.example.cosmo_lab.user.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Order {
    private int user_id;
    private Date date; // 주문일
    private String receiver;
    private String rec_address;
    private String rec_phone;
    private String result;
    private Date process_date;

    public Order() {

    }

    public Order(int user_id, Date date, String receiver, String rec_address, String rec_phone, String result, Date process_date) {
        this.user_id = user_id;
        this.date = date;
        this.receiver = receiver;
        this.rec_address = rec_address;
        this.rec_phone = rec_phone;
        this.result = result;
        this.process_date = process_date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "user_id=" + user_id +
                ", date=" + date +
                ", receiver='" + receiver + '\'' +
                ", rec_address='" + rec_address + '\'' +
                ", rec_phone='" + rec_phone + '\'' +
                ", result='" + result + '\'' +
                ", process_date=" + process_date +
                '}';
    }
}

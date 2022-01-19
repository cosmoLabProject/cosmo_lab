package com.example.cosmo_lab.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class User {
    //private int user_id;
    private String id;
    private String pw;
    private String name;
    private String nickname;
    private String email;
    private String zipcode;
    private String address;
    private String address_detail;
    private String phone;
    //private char available;
    //private Date date;

    public User() {
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                ", address_detail='" + address_detail + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

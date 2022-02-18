package com.example.cosmo_lab.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Reason {
    private int reason_id;
    private int user_id;
    private int reason_code;
    private String reason_detail;
    private Date date;

    private String pw;

    public Reason() {

    }

    public Reason(int user_id, int reason_code, String reason_detail, String pw) {
        this.user_id = user_id;
        this.reason_code = reason_code;
        this.reason_detail = reason_detail;
        this.pw = pw;
    }

    @Override
    public String toString() {
        return "Reason{" +
                "reason_id=" + reason_id +
                ", user_id=" + user_id +
                ", reason_code=" + reason_code +
                ", reason_detail='" + reason_detail + '\'' +
                ", date=" + date +
                ", pw='" + pw + '\'' +
                '}';
    }
}

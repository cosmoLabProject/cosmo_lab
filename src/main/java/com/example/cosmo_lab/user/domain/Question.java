package com.example.cosmo_lab.user.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Question {
    private int user_id;
    private String subject;
    private String content;
    private String reply;
    private char answer;
    private Date write_date;
    private Date reply_date;

    public Question() {

    }

    public Question(int user_id, String subject, String content) {
        this.user_id = user_id;
        this.subject = subject;
        this.content = content;
    }

    public Question(int user_id, String subject, String content, String reply, char answer, Date write_date, Date reply_date) {
        this.user_id = user_id;
        this.subject = subject;
        this.content = content;
        this.reply = reply;
        this.answer = answer;
        this.write_date = write_date;
        this.reply_date = reply_date;
    }

    @Override
    public String toString() {
        return "QnA{" +
                "user_id=" + user_id +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", reply='" + reply + '\'' +
                ", answer=" + answer +
                ", write_date=" + write_date +
                ", reply_date=" + reply_date +
                '}';
    }
}

package com.example.cosmo_lab.item.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Item {

 @Id
 @GeneratedValue
 private int product_id;

 private String product_name;
 private int kind;
 private int price1;
 private int price2;
 private int price3;
 private String content;
 private String image;
 private char avaliable;
 private char best_yn;
 private Date date;


 @Override
 public String toString() {
  return "Item{" +
          "product_id=" + product_id +
          ", product_name='" + product_name + '\'' +
          ", kind=" + kind +
          ", price1=" + price1 +
          ", price2=" + price2 +
          ", price3=" + price3 +
          ", content='" + content + '\'' +
          ", image='" + image + '\'' +
          ", avaliable=" + avaliable +
          ", best_yn=" + best_yn +
          ", date=" + date +
          '}';
 }


}


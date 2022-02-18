package com.example.cosmo_lab.user.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cart {
    //private int cart_id;
    private int user_id;
    private int product_id;
    private int quantity;

    private String image;
    private String product_name;
    private String content;
    private int price2; // 판매가격 (item 테이블의 price2에 해당)

    public Cart() {

    }

    public Cart(int user_id, int product_id, String image, String product_name, String content, int price2, int quantity) {
        this.user_id = user_id;
        this.product_id = product_id;
        this.image = image;
        this.product_name = product_name;
        this.content = content;
        this.price2 = price2;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", image='" + image + '\'' +
                ", product_name='" + product_name + '\'' +
                ", content='" + content + '\'' +
                ", price2=" + price2 +
                '}';
    }
}

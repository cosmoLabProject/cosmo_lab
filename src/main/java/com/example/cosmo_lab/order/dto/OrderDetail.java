package com.example.cosmo_lab.order.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private int order_d_id;
    private int order_id;
    private int product_id;
    private int quantity;    // 수량

}

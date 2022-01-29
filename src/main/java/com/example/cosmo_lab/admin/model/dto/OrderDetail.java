package com.example.cosmo_lab.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetail {

    private int orderDId;
    private int orderId;
    private int productId;
    private String orderer;
    private int quantity;
    private int totalPrice;
    private String receiver;
    private String recAddress;
    private String recPhone;
    private String result;
    private Date process_date;

}

package com.example.cosmo_lab.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryStatus {

    private String customer;
    private String address;
    private Date orderDate;
    private int price;
    private String process;

}

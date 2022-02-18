package com.example.cosmo_lab.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AddItemDto {
    private int category;
    private String status;
    private String itemName;
    private int originalPrice;
    private int sellingPrice;
    private int profit;
    private String itemImage;
    private String itemDescription;
}

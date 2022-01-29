package com.example.cosmo_lab.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ItemListDto {
    private int productId;
    private int kind;
    private String productName;
    private int price1;
    private int price2;
    private int price3;
    private String available;

    public ItemListDto(int productId, int kind, String productName, int price1, int price2, int price3, String available) {
        this.productId = productId;
        this.kind = kind;
        this.productName = productName;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.available = available;
    }
}

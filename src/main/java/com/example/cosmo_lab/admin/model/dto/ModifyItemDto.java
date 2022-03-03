package com.example.cosmo_lab.admin.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ModifyItemDto {
    private int productId;
    private int kind;
    private String available;
    private String productName;
    private int price2;
    private String image;
    private String content;

    public ModifyItemDto(int productId, int kind, String available, String productName, int price2, String image, String content) {
        this.productId = productId;
        this.kind = kind;
        this.available = available;
        this.productName = productName;
        this.price2 = price2;
        this.image = image;
        this.content = content;
    }
}

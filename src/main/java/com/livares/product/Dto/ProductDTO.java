package com.livares.product.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private String img;
    private String description;
    private int price;
    private int quantity;
    private int categoryId;
}

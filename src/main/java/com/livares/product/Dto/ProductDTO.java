package com.livares.product.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private String title;
	private String img;
	private String description;
	private int price;
	private int quantity;
	private int categoryId;
//	private String categoryName;
}

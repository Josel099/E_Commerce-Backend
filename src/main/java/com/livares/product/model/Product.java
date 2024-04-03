package com.livares.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

	
	@Column(name = "title")
	private String title;

	@Column(name = "img")
	private String img;

	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private int price;

	@Column(name = "quantity")
	private int quantity;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;
}

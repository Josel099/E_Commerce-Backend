package com.livares.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class UserProductCart extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "user_Id" , referencedColumnName="id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName="id")
	private Product product;
}

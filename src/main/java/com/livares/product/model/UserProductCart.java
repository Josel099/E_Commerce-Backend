package com.livares.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProductCart extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "user_Id" , referencedColumnName="id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName="id")
	private Product product;
}

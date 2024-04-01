package com.livares.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserProductCart extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "user_Id" , referencedColumnName="Id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName="Id")
	private Product product;
}

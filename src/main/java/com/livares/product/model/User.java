package com.livares.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{
	
	@Column(name = "first_name")
	 private String firstName;
	
	@Column(name = "last_name")
	 private String lastName;
	
	@Column(name = "user_name")
	 private String username;
	
	@Column(name = "password")
	 private String  password;
	

}

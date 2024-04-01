package com.livares.product.model;

import org.hibernate.id.factory.internal.AutoGenerationTypeStrategy;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String  firstName;
	private String lastName;
	private String username;
	private String  password;
	
}

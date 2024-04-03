package com.livares.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.UserProductCart;

public interface UserProductCartRepositery extends JpaRepository<UserProductCart,Integer>{

	
	

}

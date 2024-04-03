package com.livares.product.service;

import java.util.List;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;

public interface UserCartService {

	public String addToCart(int userId,int productId);
	
	public List<ProductDTO> getCartItemsByUserId(int userId);
	
}

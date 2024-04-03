package com.livares.product.service;

import java.util.List;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;

public interface UserCartService {

	// add products to the cart
	String addToCart(int userId, int productId);

	// get the List of products in the cart of a particular user by user ID
	List<ProductDTO> getCartItemsByUserId(int userId);

	// delete the item in the cart of a particular user.
	String deleteCartItem(int userId, int productId);
	
}

package com.livares.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;
import com.livares.product.model.User;
import com.livares.product.model.UserProductCart;
import com.livares.product.repository.ProductRepository;
import com.livares.product.repository.UserProductCartRepositery;
import com.livares.product.repository.UserRepository;
import com.livares.product.service.UserCartService;

@Service
public class UserCartServiceImp implements UserCartService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserProductCartRepositery userProductCartRepositery;

	
	
	@Override
	public String addToCart(int userId, int productId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
		Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
		UserProductCart userProductCart = new UserProductCart(user,product);
		userProductCartRepositery.save(userProductCart);
		return "product added to the cart sucessfully";
	}
	
	@Override
	public List<ProductDTO> getCartItemsByUserId(int userId) {
		return productRepository.getCartItemsByUserId(userId);
	}

}


package com.livares.product.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;
import com.livares.product.service.UserCartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserCartService userCartService;
	
	@PostMapping("/addToCart")
	public String addToCart(@RequestParam int userId,@RequestParam int productId) {
		return userCartService.addToCart(userId, productId);
	}
	
	@GetMapping("/getcartItemsById/{userId}")
	public List<ProductDTO> getCartItemsById(@PathVariable int userId){
		return userCartService.getCartItemsByUserId(userId);
		
	}
	
	@DeleteMapping("/delete/CartItem")
 public String deleteCartItem(@RequestParam int userId, @RequestParam int productId) {
		return userCartService.deleteCartItem(userId, productId);
 }
	
	
}


package com.livares.product.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;
import com.livares.product.response.ResponseHandler;
import com.livares.product.service.UserCartService;

@RestController
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private UserCartService userCartService;

	/**==============================================================
	 * Adds a product to the user's cart.
	 * @param userId The ID of the user
	 * @param productId The ID of the product to add to the cart
	 * @return A string indicating the success of adding the product to the cart
	 *==============================================================*/
	@PostMapping("/addToCart")
	public ResponseEntity<Object> addToCart(@RequestParam int userId,@RequestParam int productId) {
		return ResponseHandler.generateResponse(userCartService.addToCart(userId, productId),HttpStatus.ACCEPTED,null)  ;
	}

	/**==============================================================
	 * Retrieves all products in the user's cart by user ID.
	 * @param userId The ID of the user
	 * @return A list of ProductDTO objects representing the products in the user's cart
	 *=================================================================*/
	@GetMapping("/getcartItemsById/{userId}")
	public ResponseEntity<Object> getCartItemsById(@PathVariable int userId){
		return  ResponseHandler.generateResponse("Cart items of User having Id : "+ userId, HttpStatus.OK, userCartService.getCartItemsByUserId(userId)) ;
		
	}
	/**==============================================================
	 * Deletes a product from the user's cart.
	 * @param userId The ID of the user
	 * @param productId The ID of the product to delete from the cart
	 * @return A string indicating the success of deleting the product from the cart
	 *============================================================== */
	@DeleteMapping("/delete/CartItem")
 	public ResponseEntity<Object> deleteCartItem(@RequestParam int userId, @RequestParam int productId) {
		return ResponseHandler.generateResponse(userCartService.deleteCartItem(userId, productId), HttpStatus.ACCEPTED,null) ;
 }
}

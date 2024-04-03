package com.livares.product.service.impl;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;
import com.livares.product.model.User;
import com.livares.product.model.UserProductCart;
import com.livares.product.repository.ProductRepository;
import com.livares.product.repository.UserProductCartRepositery;
import com.livares.product.repository.UserRepository;
import com.livares.product.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class UserCartServiceImp implements UserCartService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserProductCartRepositery userProductCartRepositery;


    /**
     * ===================================================================
     * method for Adding  a product to the user's cart.
     * Checking the item is  already in the cart if not then  added to the cart
     * @param userId    The ID of the user
     * @param productId The ID of the product to be added to the cart
     * @return A string indicating whether the product was successfully added to the cart or if it's already in the cart
     * =====================================================================
     */

    @Override
    public String addToCart(int userId, int productId) {
        // Find there exist an  cart entry by userId and productId
        Integer cartId = userProductCartRepositery.findByUserIdAndProductId(userId, productId);
        if (cartId == null) {
            User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
            Product product = productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Product not found"));
            UserProductCart userProductCart = new UserProductCart(user, product);
            userProductCartRepositery.save(userProductCart);
            return "product added to the cart sucessfully";
        }
        return "Product already in the cart";
    }


    /**
     * ==============================================
     * method for find cart items of particular user
     * @param userId The Id of the user
     * @return List of Items in the cart of a user
     * ================================================
     */
    @Override
    public List<ProductDTO> getCartItemsByUserId(int userId) {
        return productRepository.getCartItemsByUserId(userId);
    }


    /**
     * =================================================================================
     * Service method to delete a cart item by user ID and product ID.
     * Attempts to delete the cart item  associated with the given user ID and product ID.
     * @param userId    The ID of the user whose cart item is to be deleted
     * @param productId The ID of the product to be deleted from the user's cart
     * @return A message indicating the result of the deletion operation
     * ===================================================================================
     */
    @Override
    public String deleteCartItem(int userId, int productId) {

        // Find the cart entry by userId and productId
        Integer cartId = userProductCartRepositery.findByUserIdAndProductId(userId, productId);
        // Delete the cart entry by cartId
        if (cartId != null) {
            userProductCartRepositery.deleteById(cartId);
            return "deleted Product sucessfully";
        } else return "Error: Unable to delete the cart item";


    }

}

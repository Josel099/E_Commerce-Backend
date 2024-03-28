package com.livares.product.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livares.product.model.Product;
import com.livares.product.repository.ProductRepository;


/**===============================================================
 * Service class implementing ProductServiceInterface.
 * Provides methods to perform CRUD operations on Product entities.
 ===================================================================*/
@Service
public class ProductService implements ProductServiceInterface {
	
	@Autowired
	private ProductRepository productRepository;
	
	/**==============================================
	 * Saves a new product.
	 * @param product The product to be saved.
	 * @return The saved product.
	 =================================================*/
	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	/**==================================
	 * Retrieves all products.
	 * @return A list of all products.
	 ====================================*/
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	/**=======================================================================
	 * Retrieves a product by its ID.
	 * @param Id The ID of the product to retrieve.
	 * @return An Optional containing the product if found, or empty otherwise.
	 ===========================================================================*/
	@Override
	public Optional<Product> getProductById(int Id) {
		return productRepository.findById(Id);
	}
	
	/**===============================================================================
	 * Updates an existing product.
	 * @param Id The ID of the product to update.
	 * @param product The updated product details.
	 * @return The updated product.
	 * @throws NoSuchElementException if the product with the specified ID is not found.
	 ==================================================================================*/
	@Override
	public Product updateProduct(int Id, Product product) {
		Product product2Update = productRepository.findById(Id).orElseThrow();
		product2Update.setTitle(product.getTitle());
		product2Update.setImg(product.getImg());
		product2Update.setDescription(product.getDescription());
		product2Update.setPrice(product.getPrice());
		return productRepository.save(product2Update);
	}
	
	/**==========================================
	 * Deletes a product by its ID.
	 * @param Id The ID of the product to delete.
	 =============================================*/
	@Override
	public void deleteProduct(int Id) {
		productRepository.deleteById(Id);
	}
	
	/**=====================
	 * Deletes all products.
	 ========================*/
	@Override
	public void deleteAllProduct() {
		productRepository.deleteAll();
	}
	
}



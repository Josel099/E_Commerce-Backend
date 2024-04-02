package com.livares.product.service;

import java.util.List;
import java.util.Optional;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;

/**===================================================================
 * Interface for ProductService.
 * Defines methods for performing CRUD operations on Product entities.
 =====================================================================*/
public interface ProductServiceInterface {

	//Saves a new product.
	public void saveProduct(ProductDTO productDTO );

	//Save multiple product
	public void saveAllProducts(List<ProductDTO> productDTOList);

	//Retrieves all products.
	public List<Product> getAllProducts();
	
	//Retrieves a product by its ID.
	public Optional<Product> getProductById(int Id);

	//Updates an existing product.
	public Product updateProduct(int Id,ProductDTO productDTO) ;

	//Deletes a product by its ID.
	public void deleteProduct(int Id);

	//Deletes all products.
	public void deleteAllProduct();
	
	//get products by it's category
	public List<Product> getProductByCategory(String category);
}

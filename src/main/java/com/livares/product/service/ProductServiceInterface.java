package com.livares.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Category;
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
	
	
	
	// categoriea methods
	
	// adding a new category
	public String saveCategory(CategoryDTO categoryDTO);


	//displaying all categories in the database
	public List<Category> getAllCategory();

	
	// get product by pagable request 
	public Page<Product> getProductByPages(int pageNo, int pageSize);
}

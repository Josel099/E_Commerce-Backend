package com.livares.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Category;
import com.livares.product.model.Product;

public interface ProductService {


    /**===================================================================
     * Defines methods for performing CRUD operations on Product entities.
     =====================================================================*/

	//Saves a new product.
    void saveProduct(ProductDTO productDTO);

	//Save multiple product
    void saveAllProducts(List<ProductDTO> productDTOList);

	//Retrieves all products.
    List<Product> getAllProducts();
	
	//Retrieves a product by its ID.
    Optional<Product> getProductById(int Id);

	//Updates an existing product.
    Product updateProduct(int Id, ProductDTO productDTO) ;

	//Deletes a product by its ID.
    void deleteProduct(int Id);

	//Deletes all products.
    void deleteAllProduct();
	
	//get products by it's category
    List<Product> getProductByCategory(String category);



    /**===================================================================
     * Defines methods for performing CRUD operations on Category entities.
     =====================================================================*/

	// adding a new category
    String saveCategory(CategoryDTO categoryDTO);


	//displaying all categories in the database
    List<Category> getAllCategory();

	
	// get product list by the pageable request
    Page<Product> getProductByPages(int pageNo, int pageSize);
}

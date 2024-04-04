package com.livares.product.controller;

import java.util.List;
import java.util.Optional;
import java.util.PrimitiveIterator.OfDouble;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Category;
import com.livares.product.model.Product;
import com.livares.product.response.ResponseHandler;
import com.livares.product.service.ProductService;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**==============================================================
	 * Saves a single product to the database.
	 * @param productDTO The ProductDTO containing details of the product to be saved
	 * @return A string indicating the success of the operation
	==============================================================*/
     	@PostMapping("/save")
	public ResponseEntity<Object> saveProduct(@RequestBody ProductDTO productDTO) {
     		productService.saveProduct(productDTO);
		return  ResponseHandler.generateResponse("Product saved successfully",HttpStatus.ACCEPTED, productDTO);
	}


	/**==============================================================
	 * Saves multiple products to the database.
	 * @param productDTOList The list of ProductDTO objects containing details of the products to be saved
	 * @return A string indicating the success of the operation
	==================================================================*/
	@PostMapping("/saveAll")
	public ResponseEntity<Object> saveAllProduct(@RequestBody List<ProductDTO> productDTOList){
			 productService.saveAllProducts(productDTOList);
			 return ResponseHandler.generateResponse("All products saved sucessfully",HttpStatus.ACCEPTED, productDTOList);
	}

	/**==============================================================
	 * Retrieves all products from the database.
	 * @return A list of Product objects representing all products in the database
	==============================================================*/
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAllProducts(){
		return ResponseHandler.generateResponse("List of products in the database", HttpStatus.OK, productService.getAllProducts()); 
	}



	/**==============================================================
	 * Retrieves a product by its ID.
	 * @param Id The ID of the product to retrieve
	 * @return An Optional containing the Product object if found, or empty if not found
	==============================================================*/
	@GetMapping("/getById/{Id}")
	public ResponseEntity<Object> getProductById(@PathVariable int Id){
		return ResponseHandler.generateResponse("Details of product having  ID : "+Id, HttpStatus.OK, productService.getProductById(Id));
	}



	/**==============================================================
	 * Updates a product with the specified ID.
	 * @param Id The ID of the product to update
	 * @param productDTO The ProductDTO containing updated details of the product
	 * @return The updated Product object
	 * ==============================================================*/
	 	@PutMapping("/updateProduct/{Id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int Id,@RequestBody ProductDTO productDTO) {
		return ResponseHandler.generateResponse("Product Updated Sucessfully", HttpStatus.ACCEPTED,productService.updateProduct(Id, productDTO));
	}


	/**==============================================================
	 * Deletes a product by its ID.
	 * @param Id The ID of the product to delete
	 * @return A string indicating the success of the operation
	==============================================================*/
	@DeleteMapping("/deleteProduct/{Id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int Id) {
		productService.deleteProduct(Id);
		return ResponseHandler.generateResponse("Product deleted from the database",HttpStatus.OK,null) ;
	}



	/**==============================================================
	 * Deletes all products from the database.
	 * @return A string indicating the success of the operation
	============================================================== */
	@DeleteMapping("/deleteAll")
	public  ResponseEntity<Object> deleteAllProduct() {
		productService.deleteAllProduct();
		return ResponseHandler.generateResponse("All Products deleted from the database",HttpStatus.OK,null);
	}


	/**==============================================================
	 * Retrieves products with a particular category.
	 * @param category The name of the category
	 * @return A list of Product objects belonging to the specified category
	==============================================================*/
		@GetMapping("/getProductsbyCategory/{category}")
		public ResponseEntity<Object> getProductByCategory(@PathVariable String category) {
			return  ResponseHandler.generateResponse("All Product of  Category:"+category, HttpStatus.OK, productService.getProductByCategory(category));
		}


	/**==============================================================
	 * Retrieves products by pagination.
	 * @param pageNo The page number
	 * @param pageSize The size of each page
	 * @return A Page object containing products for the specified page
	 *==============================================================*/
		@GetMapping("/getProductsByPagination")
		public ResponseEntity<Object> getProductByPages( @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize)
		{
			return  ResponseHandler.generateResponse(" list of product in Page NO :"+pageNo, HttpStatus.OK,  productService.getProductByPages(pageNo,pageSize)) ;
			
		}



	/**=====================================
	 *** Category entity related endpoints .**
	 ========================================*/


	/**==============================================================
	 * Adds a new category to the database.
	 * @param categoryDTO The CategoryDTO containing details of the category to be added
	 * @return A string indicating the success of the operation
	 *==============================================================*/
	     @PostMapping("/addCategory")
	     public ResponseEntity<Object> addCategory(@RequestBody CategoryDTO categoryDTO){
	        return  ResponseHandler.generateResponse("category added sucessfully",HttpStatus.ACCEPTED,null) ;
	     }



	/**==============================================================
	 * Retrieves all categories from the database.
	 * @return A list of Category objects representing all categories
	 *==============================================================*/
	     @GetMapping("/getAllCategory")
	     public ResponseEntity<Object> getAll(){
	         return ResponseHandler.generateResponse("List of All Available Categories",HttpStatus.OK, productService.getAllCategory());
	     }
		
	     
	     
}   

	
	
	
	
	
	
	


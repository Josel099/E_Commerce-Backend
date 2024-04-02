package com.livares.product.controller;

import java.util.List;
import java.util.Optional;

import com.livares.product.Dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.livares.product.model.Product;
import com.livares.product.service.ProductServiceInterface;



@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	
	 // Saves a product to the database
     	@PostMapping("/save")
	public String saveProduct(@RequestBody ProductDTO productDTO) {
		productServiceInterface.saveProduct(productDTO);
		return "Product saved successfully";
	}

   // endpoint for saving multiple product at a time
	@PostMapping("/saveAll")
	public String saveAllProduct(@RequestBody List<ProductDTO> productDTOList){
			 productServiceInterface.saveAllProducts(productDTOList);
			 return "all products saved sucessfully";
	}
	
	 //Retrieves all products from the database.
	@GetMapping("/getAll")
	public List<Product> getAllProducts(){
		return productServiceInterface.getAllProducts();
	}
	
	//Retrieves a product by its ID. 
	@GetMapping("/getById/{Id}")
	public Optional<Product> getProductById(@PathVariable int Id){
		return productServiceInterface.getProductById(Id);
	}
	
	
	 //Updates a product
	@PutMapping("/updateProduct/{Id}")
	public Product updateProduct(@PathVariable int Id,@RequestBody ProductDTO productDTO) {
		return productServiceInterface.updateProduct(Id, productDTO);
	}
	
	
	// Delete product by Id 
	@DeleteMapping("/deleteProduct/{Id}")
	public String deleteProduct(@PathVariable int Id) {
		productServiceInterface.deleteProduct(Id);
		return "Product deleted from the database";
	}
	
	
	
	// Deletes all products
	@DeleteMapping("/deleteAll")
	public  String deleteAllProduct() {
		productServiceInterface.deleteAllProduct();
		return "All products deleted from the database";
	}
	
	// endpoint for  select products with particular category
		@GetMapping("/getProductsbyCategory/{category}")
		public List<Product> getProductByCategory(@PathVariable String category) {
			System.out.println(category);
			return productServiceInterface.getProductByCategory(category);
		}
		
		
		
		
}

	
	
	
	
	
	
	


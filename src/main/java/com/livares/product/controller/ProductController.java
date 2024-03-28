package com.livares.product.controller;

import java.util.List;
import java.util.Optional;

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
	public String saveProduct(@RequestBody Product product) {
		productServiceInterface.saveProduct(product);
		return "Product saved successfully";
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
	public Product updateProduct(@PathVariable int Id,@RequestBody Product product) {
		return productServiceInterface.updateProduct(Id, product);
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
}

	
	
	
	
	
	
	


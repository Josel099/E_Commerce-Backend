package com.livares.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	public String saveProduct(@RequestBody ProductDTO productDTO) {
		productService.saveProduct(productDTO);
		return "Product saved successfully";
	}


	/**==============================================================
	 * Saves multiple products to the database.
	 * @param productDTOList The list of ProductDTO objects containing details of the products to be saved
	 * @return A string indicating the success of the operation
	==================================================================*/
	@PostMapping("/saveAll")
	public String saveAllProduct(@RequestBody List<ProductDTO> productDTOList){
			 productService.saveAllProducts(productDTOList);
			 return "all products saved sucessfully";
	}

	/**==============================================================
	 * Retrieves all products from the database.
	 * @return A list of Product objects representing all products in the database
	==============================================================*/
	@GetMapping("/getAll")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}



	/**==============================================================
	 * Retrieves a product by its ID.
	 * @param Id The ID of the product to retrieve
	 * @return An Optional containing the Product object if found, or empty if not found
	==============================================================*/
	@GetMapping("/getById/{Id}")
	public Optional<Product> getProductById(@PathVariable int Id){
		return productService.getProductById(Id);
	}



	/**==============================================================
	 * Updates a product with the specified ID.
	 * @param Id The ID of the product to update
	 * @param productDTO The ProductDTO containing updated details of the product
	 * @return The updated Product object
	 * ==============================================================*/
	 	@PutMapping("/updateProduct/{Id}")
	public Product updateProduct(@PathVariable int Id,@RequestBody ProductDTO productDTO) {
		return productService.updateProduct(Id, productDTO);
	}


	/**==============================================================
	 * Deletes a product by its ID.
	 * @param Id The ID of the product to delete
	 * @return A string indicating the success of the operation
	==============================================================*/
	@DeleteMapping("/deleteProduct/{Id}")
	public String deleteProduct(@PathVariable int Id) {
		productService.deleteProduct(Id);
		return "Product deleted from the database";
	}



	/**==============================================================
	 * Deletes all products from the database.
	 * @return A string indicating the success of the operation
	============================================================== */
	@DeleteMapping("/deleteAll")
	public  String deleteAllProduct() {
		productService.deleteAllProduct();
		return "All products deleted from the database";
	}


	/**==============================================================
	 * Retrieves products with a particular category.
	 * @param category The name of the category
	 * @return A list of Product objects belonging to the specified category
	==============================================================*/
		@GetMapping("/getProductsbyCategory/{category}")
		public List<Product> getProductByCategory(@PathVariable String category) {
			return productService.getProductByCategory(category);
		}


	/**==============================================================
	 * Retrieves products by pagination.
	 * @param pageNo The page number
	 * @param pageSize The size of each page
	 * @return A Page object containing products for the specified page
	 *==============================================================*/
		@GetMapping("/getProductsByPagination")
		public Page<Product> getProductByPages( @RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "5") Integer pageSize)
		{
			return productService.getProductByPages(pageNo,pageSize);
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
	     public String addCategory(@RequestBody CategoryDTO categoryDTO){
	        return productService.saveCategory(categoryDTO);
	     }



	/**==============================================================
	 * Retrieves all categories from the database.
	 * @return A list of Category objects representing all categories
	 *==============================================================*/
	     @GetMapping("/getAllCategory")
	     public List<Category> getAll(){
	         return  productService.getAllCategory();
	     }
		
	     
	     
}   

	
	
	
	
	
	
	


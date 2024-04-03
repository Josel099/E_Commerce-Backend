package com.livares.product.service.impl;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Category;
import com.livares.product.model.Product;
import com.livares.product.repository.CategoryRepository;
import com.livares.product.repository.ProductRepository;
import com.livares.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * ===============================================================
 * Service class implementing ProductServiceInterface.
 * Provides methods to perform CRUD operations on Product entities.
 * ===================================================================
 */
@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * ==============================================
     * Saves a new product.
     *
     * @param productDTO The product to be saved.
     *                   =================================================
     */
    @Override
    public void saveProduct(ProductDTO productDTO) {
        Product product = convertToProduct(productDTO);
        productRepository.save(product);
    }


    /**
     * ===============================================================================
     * Saves a list of products by converting ProductDTO objects to Product entities
     * and then saving them in the database.
     *
     * @param productDTOList A list of ProductDTO objects to be saved in the Database
     *                       =================================================================================
     */
    @Override
    public void saveAllProducts(List<ProductDTO> productDTOList) {
        List<Product> products = productDTOList.stream().map(this::convertToProduct) // .map(productDTO -> convertToProduct(productDTO))
                .collect(Collectors.toList());
        productRepository.saveAll(products);
    }


    /**
     * =================================================================
     * Helper method to convert a ProductDTO object to a Product entity.
     *
     * @param productDTO The ProductDTO object to be converted
     * @return The corresponding Product entity
     * ====================================================================
     */
    private Product convertToProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new NotFoundException("Category not found"));
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setImg(productDTO.getImg());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(category); // Set the Category foreignKey
        return product;
    }


    /**
     * ==================================
     * Retrieves all products.
     *
     * @return A list of all products.
     * ====================================
     */
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * =======================================================================
     * Retrieves a product by its ID.
     *
     * @param Id The ID of the product to retrieve.
     * @return An Optional containing the product if found, or empty otherwise.
     * ===========================================================================
     */
    @Override
    public Optional<Product> getProductById(int Id) {
        return productRepository.findById(Id);
    }

    /**
     * ===============================================================================
     * Updates an existing product.
     *
     * @param Id         The ID of the product to update.
     * @param productDTO The updated product details.
     * @return The updated product.
     * @throws NoSuchElementException if the product with the specified ID is not found.
     *                                ==================================================================================
     */
    @Override
    public Product updateProduct(int Id, ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new NotFoundException("Category not found"));

        Product productToUpdate = productRepository.findById(Id).orElseThrow();
        productToUpdate.setTitle(productDTO.getTitle());
        productToUpdate.setImg(productDTO.getImg());
        productToUpdate.setDescription(productDTO.getDescription());
        productToUpdate.setPrice(productDTO.getPrice());
        productToUpdate.setQuantity(productDTO.getQuantity());
        productToUpdate.setCategory(category); // Set the Category association
        // Save the updated Product entity back to the database
        return productRepository.save(productToUpdate);
    }


    /**
     * ==========================================
     * Deletes a product by its ID.
     *
     * @param Id The ID of the product to delete.
     *           =============================================
     */
    @Override
    public void deleteProduct(int Id) {
        productRepository.deleteById(Id);
    }

    /**
     * =====================
     * Deletes all products.
     * ========================
     */
    @Override
    public void deleteAllProduct() {
        productRepository.deleteAll();
    }


    /**
     * ==========================================
     * get list of   products by its category name.
     *
     * @param categoryName The category name of the products to fetch.
     * @return =============================================
     */
    @Override
    public List<Product> getProductByCategory(String categoryName) {
        return productRepository.findProductByCategory(categoryName);
    }


    /**
     * =====================================================================
     * Retrieves a page of products based on the specified page number and page size.
     * Implementation of Pagination
     *
     * @param pageNo   The page number to retrieve
     * @param pageSize The number of items in  each page
     * @return A page containing the requested products
     * =====================================================================
     */
    @Override
    public Page<Product> getProductByPages(int pageNo, int pageSize) {

        //create pagerequest object
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        //pass it to repos
        Page<Product> pagingUser = productRepository.findAll(pageRequest);

        //pagingUser.hasContent(); -- to check pages are there or not

        return pagingUser;
    }


    /**===================================================================
     * Service  Implementations for  Category entity.
     =====================================================================*/


    /**
     * =====================================================================
     * Saves a new category to the database based on the provided CategoryDTO.
     *
     * @param categoryDTO The CategoryDTO object containing the category details
     * @return A message indicating that the category has been added
     * =====================================================================
     */
    @Override
    public String saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        String name = categoryDTO.getCategoryName();
        category.setCategoryName(name);
        categoryRepository.save(category);
        return "Category Added";
    }

    /**
     * =====================================================================
     * Retrieves all categories from the database.
     *
     * @return A list containing all categories
     * =====================================================================
     */
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

}



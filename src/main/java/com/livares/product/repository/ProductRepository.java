package com.livares.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.livares.product.Dto.ProductDTO;
import com.livares.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	/**=============================================================
	 * Retrieves a list of products belonging to a specific category.
	 * @param categoryName The name of the category
	 * @return A list of products belonging to the specified category
	================================================================= */
	@Query(nativeQuery = true, value = "SELECT p.* FROM product p JOIN category c ON p.category_id = c.id WHERE c.category_name = :categoryName")
	List<Product> findProductByCategory(@Param("categoryName") String categoryName);

	/**===================================================================================
	 * Retrieves a list of ProductDTO objects representing cart items for a specific user.
	 * @param userId The ID of the user
	 * @return A list of ProductDTO objects representing cart items for the specified user
	 =======================================================================================*/
	@Query(value = "SELECT new com.livares.product.Dto.ProductDTO(p.title,p.img,p.description,p.price,p.quantity,p.category.Id)"
			+ "FROM Product p JOIN  com.livares.product.model.UserProductCart upc"
			+ " ON p.Id = upc.product.Id"
			+ " WHERE upc.user.id = :userId")
	List<ProductDTO> getCartItemsByUserId(@Param("userId") int userId);







// hibernet query for getting products belonging to a specific category
	/**
	  * @Query("SELECT new
	 * com.livares.product.Dto.ProductDTO(p.title,p.image,p.description,p.price,p.quantity,c.categoryName,c.categoryId)
	 * FROM Product p " + "JOIN Category c ON p.category.id = c.id " + "WHERE c.name
	 * = :category") List<ProductDTO> findProductByCategory1(@Param("category")
	 * String category);
	 */

	// native query for getting cart items of a particular user
	/**
	 	 * @Query(value="SELECT
	 * p.title,p.img,p.description,p.price,p.quantity,p.category_id" + "FROM product
	 * p JOIN user_product_cart upa " + " ON p.Id = upa.product_id " + "WHERE
	 * upa.user_id = :userId", nativeQuery = true) List<Product>
	 * getCartItemsByUserId(@Param("userId") int userId);
	 */
}

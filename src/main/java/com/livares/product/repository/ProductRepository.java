package com.livares.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.livares.product.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@Query(nativeQuery = true,
			value = "SELECT p.* FROM product p JOIN category c ON p.category_id = c.id WHERE c.category_name = :categoryName")
List<Product> findProductByCategory(@Param("categoryName") String categoryName);

	
//	@Query("SELECT new com.livares.product.Dto.ProductDTO(p.title,p.image,p.description,p.price,p.quantity,c.categoryName,c.categoryId) FROM Product p "
//			+ "JOIN Category c ON p.category.id = c.id "
//			+ "WHERE c.name = :category")
//		List<ProductDTO> findProductByCategory1(@Param("category") String category);
	
	
}

package com.livares.product.repository;

import com.livares.product.model.Category;
import com.livares.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}

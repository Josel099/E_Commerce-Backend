package com.livares.product.service;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.model.Category;

import java.util.List;

public interface CategoryServiceInterface {
// adding a new category
public String saveCategory(CategoryDTO categoryDTO);

// deleting an existing category by it's Id
//public String deleteCategoryById(int id); : problem when try to delete bcz relation ship established



//displaying all categories in the database
public List<Category> getAllCategory();
}

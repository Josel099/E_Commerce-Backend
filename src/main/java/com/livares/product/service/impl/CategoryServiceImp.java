package com.livares.product.service.impl;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.model.Category;
import com.livares.product.repository.CategoryRepository;
import com.livares.product.service.CategoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryServiceInterface {

@Autowired
 public CategoryRepository categoryRepository;
    @Override
    public String saveCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        String name = categoryDTO.getCategoryName();
        System.out.println(name);
        category.setCategoryName(name);
        categoryRepository.save(category);
        return "Category Added";
    }

//    @Override method for delete category by it's Id
//    public String deleteCategoryById(int id) {
//        categoryRepository.deleteById(id);
//        return "Product Detleted";
//    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
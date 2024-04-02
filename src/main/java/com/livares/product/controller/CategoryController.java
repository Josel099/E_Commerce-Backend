package com.livares.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.model.Category;
import com.livares.product.service.CategoryServiceInterface;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
   private CategoryServiceInterface categoryServiceInterface;
    // adding a new category to the db
    @PostMapping("/addCategory")
    public String addCategory(@RequestBody CategoryDTO categoryDTO){
       return categoryServiceInterface.saveCategory(categoryDTO);
    }

//    // delete an category by it's Id
//    @DeleteMapping("/delete/{Id}")
//    public String deleteById(@PathVariable int Id){
//        return categoryServiceInterface.deleteCategoryById(Id);
//    }

    @GetMapping("/getAllCategory")
    public List<Category> getAll(){
        return  categoryServiceInterface.getAllCategory();
    }



}

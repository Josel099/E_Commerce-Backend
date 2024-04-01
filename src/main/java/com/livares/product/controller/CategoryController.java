package com.livares.product.controller;

import com.livares.product.Dto.CategoryDTO;
import com.livares.product.model.Category;
import com.livares.product.service.CategoryServiceInterface;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

package com.tobeto.spring.workshop.b.controller;

import com.tobeto.spring.workshop.b.module.Category;
import com.tobeto.spring.workshop.b.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getall")
    public List<Category> getAllCategories() {
        return this.categoryService.getall();
    }

    @GetMapping("/get/{id}")
    public Category getCategoryById(@PathVariable int id) {
        return this.categoryService.getById(id);
    }

    @PostMapping("/add")
    public String createCategory(@RequestBody Category category) {
        return this.categoryService.add(category);
    }

    @PutMapping("/update/{id}")
    public String updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        return this.categoryService.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        return this.categoryService.delete(id);
    }
}

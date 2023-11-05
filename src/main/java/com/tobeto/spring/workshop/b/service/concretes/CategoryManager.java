package com.tobeto.spring.workshop.b.service.concretes;

import com.tobeto.spring.workshop.b.module.Category;
import com.tobeto.spring.workshop.b.repository.abstracts.CategoryRepository;
import com.tobeto.spring.workshop.b.service.abstracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    CategoryRepository categories;

    @Autowired
    public CategoryManager(CategoryRepository categoryRepository) {
        this.categories = categoryRepository;
    }

    @Override
    public List<Category> getall() {
        return categories.getall();
    }

    @Override
    public Category getById(int id) {
        return categories.getById(id);
    }

    @Override
    public String add(Category category) {
        return categories.add(category);
    }

    @Override
    public String delete(int id) {
        return categories.delete(id);
    }

    @Override
    public String updateCategory(int id, Category updatedCategory) {
        return categories.updateCategory(id, updatedCategory);
    }
}

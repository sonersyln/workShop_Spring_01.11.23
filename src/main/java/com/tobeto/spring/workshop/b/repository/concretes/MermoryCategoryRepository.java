package com.tobeto.spring.workshop.b.repository.concretes;

import com.tobeto.spring.workshop.b.module.Category;
import com.tobeto.spring.workshop.b.repository.abstracts.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MermoryCategoryRepository implements CategoryRepository {
    List<Category> categories;

    public MermoryCategoryRepository() {
        this.categories = new ArrayList<>();
        categories.add(new Category(1, "Electronics"));
        categories.add(new Category(2, "Books"));
        categories.add(new Category(3, "Fashion"));
        categories.add(new Category(4, "Accessories"));
    }

    @Override
    public List<Category> getall() {
        return categories;
    }

    @Override
    public Category getById(int id) {
        Category category = categories.stream().filter(c -> c.getId() == id).findFirst().orElseThrow();
        return category;
    }

    @Override
    public String add(Category category) {
        categories.add(category);
        return category.getName() + " category added successfully.";
    }

    @Override
    public String delete(int id) {
        Category category = categories.stream().filter(c -> c.getId() == id).findFirst().orElseThrow();
        categories.remove(category);
        return category.getName() + " category deleted successfully!";
    }

    @Override
    public String updateCategory(int id, Category updatedCategory) {
        Category category = categories.stream().filter(c -> c.getId() == id).findFirst().orElseThrow();

        category.setName(updatedCategory.getName());

        return "Category updated! \nID: " + id + ", \nNew Information: \nName: " + updatedCategory.getName();
    }
}
package com.tobeto.spring.workshop.b.repository.abstracts;

import com.tobeto.spring.workshop.b.module.Category;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository {
    String add(Category category);

    List<Category> getall();

    String delete(int id);

    String updateCategory(int id, Category updatedCategory);

    Category getById(int id);

}

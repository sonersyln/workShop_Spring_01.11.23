package com.tobeto.spring.workshop.b.service.abstracts;

import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.module.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> getall();
    String add(Product product);
    String delete(int id);
    String updateProduct(int id, Product updatedProduct);
}

package com.tobeto.spring.workshop.b.service.concretes;


import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.repository.abstracts.ProductRepository;
import com.tobeto.spring.workshop.b.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductManager implements ProductService {

    ProductRepository products;
@Autowired
    public ProductManager(ProductRepository productRepository) {
        this.products = productRepository;
    }

    @Override
    public List<Product> getall() {
        return products.getall();
    }

    @Override
    public String add(Product product) {
       return products.add(product);
    }

    @Override
    public String delete(int id) {
        return products.delete(id);
    }

    @Override
    public String updateProduct(int id, Product updatedProduct) {
        return products.updateProduct(id, updatedProduct);
    }
}

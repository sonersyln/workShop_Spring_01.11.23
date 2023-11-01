package com.tobeto.spring.workshop.b.controller;

import com.tobeto.spring.workshop.b.module.Product;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    List<Product> items = new ArrayList<>();

    @PostConstruct
    public void initializeProducts() {
        items.add(new Product(1, "Phone", 1499.99, 100, "Electronics"));
        items.add(new Product(2, "TV", 2599.99, 50, "Electronics"));
        items.add(new Product(3, "Book", 19.99, 200, "Books"));
        items.add(new Product(4, "Clothing", 49.99, 150, "Fashion"));
        items.add(new Product(5, "Watch", 299.99, 80, "Accessories"));
        items.add(new Product(6, "Shoes", 79.99, 120, "Footwear"));
        items.add(new Product(7, "Table", 199.99, 30, "Furniture"));
        items.add(new Product(8, "Camera", 899.99, 40, "Electronics"));
        items.add(new Product(9, "Dining Set", 149.99, 60, "Home Decor"));
        items.add(new Product(10, "Perfume", 39.99, 90, "Cosmetics"));
    }

    @GetMapping("/getall")
    public List<Product> getAllProductsSortedById() {
        return items.stream()
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product) {
        this.items.add(product);
        return product.getName() + " product added successfully.";
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        for (Product product : items) {
            if (product.getId() == id) {
                product.setName(updatedProduct.getName());
                product.setCategory(updatedProduct.getCategory());
                product.setStock(updatedProduct.getStock());
                product.setPrice(updatedProduct.getPrice());

                return product.getName() + " product updated successfully!";
            }
        }
        return "Product not found!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                items.remove(product);
                return product.getName() + " product deleted successfully.";
            }
        }
        return "Product not found!";
    }
}

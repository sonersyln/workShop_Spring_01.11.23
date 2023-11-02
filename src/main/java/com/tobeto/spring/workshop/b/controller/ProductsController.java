package com.tobeto.spring.workshop.b.controller;
import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.service.abstracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    ProductService productService;
@Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getall")
    public List<Product> getAllProductsSortedById() {
        return productService.getall();
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return this.productService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return this.productService.delete(id);
    }
}

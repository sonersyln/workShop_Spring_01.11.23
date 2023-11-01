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
        items.add(new Product(1, "Telefon", 1499.99, 100, "Elektronik"));
        items.add(new Product(2, "Televizyon", 2599.99, 50, "Elektronik"));
        items.add(new Product(3, "Kitap", 19.99, 200, "Kitap"));
        items.add(new Product(4, "Giyim", 49.99, 150, "Moda"));
        items.add(new Product(5, "Saat", 299.99, 80, "Aksesuar"));
        items.add(new Product(6, "Ayakkabı", 79.99, 120, "Ayakkabı"));
        items.add(new Product(7, "Masa", 199.99, 30, "Mobilya"));
        items.add(new Product(8, "Kamera", 899.99, 40, "Elektronik"));
        items.add(new Product(9, "Yemek Takımı", 149.99, 60, "Ev Eşyaları"));
        items.add(new Product(10, "Parfüm", 39.99, 90, "Kozmetik"));
    }

    @GetMapping("/getall")
    public List<Product> getAllProductsSortedById(){
        return items.stream()
                .sorted(Comparator.comparingInt(Product::getId))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public String createProduct(@RequestBody Product product){
        this.items.add(product);
        return product.getName() + " adlı ürün başarıyla eklendi.";
    }

    @PutMapping("/update/{id}")
    public String updateProduct (@PathVariable int id, @RequestBody Product updateProduct){
        for (Product product : items) {
            if (product.getId() == id){
                product.setName(updateProduct.getName());
                product.setCategory(updateProduct.getCategory());
                product.setStock(updateProduct.getStock());
                product.setPrice(updateProduct.getPrice());

                return product.getName() + " adlı ürün başarıyla güncellendi!";
            }
        }
        return "Ürün bulunamadı!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        for (Product product : items) {
            if (product.getId() == id) {
                items.remove(product);
                return product.getName() + " adlı ürün başarıyla silindi.";
            }
        }
        return "Ürün bulunamadı!";
    }
}

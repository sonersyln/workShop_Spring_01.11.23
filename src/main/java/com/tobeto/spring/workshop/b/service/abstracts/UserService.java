package com.tobeto.spring.workshop.b.service.abstracts;

import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.module.User;

import java.util.List;

public interface UserService {
    List<User> getall();
    String add(User user);
    String delete(int id);
    String updateProduct(int id, User updatedUser);

}

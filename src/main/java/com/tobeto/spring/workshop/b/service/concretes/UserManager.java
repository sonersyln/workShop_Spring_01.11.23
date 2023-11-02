package com.tobeto.spring.workshop.b.service.concretes;

import com.tobeto.spring.workshop.b.module.Product;
import com.tobeto.spring.workshop.b.module.User;
import com.tobeto.spring.workshop.b.repository.abstracts.UserRepository;
import com.tobeto.spring.workshop.b.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserManager implements UserService {
    UserRepository users;
@Autowired
    public UserManager(UserRepository users) {
        this.users = users;
    }

    @Override
    public List<User> getall() {
        return users.getall();
    }

    @Override
    public String add(User user) {
        return users.add(user);
    }

    @Override
    public String delete(int id) {
        return users.delete(id);
    }

    @Override
    public String updateProduct(int id, User updatedUser) {
        return users.updateUser(id,updatedUser);
    }
}

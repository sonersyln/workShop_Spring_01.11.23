package com.tobeto.spring.workshop.b.controller;

import com.tobeto.spring.workshop.b.module.User;
import com.tobeto.spring.workshop.b.service.abstracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    UserService userService;
@Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public List<User> getAllUsersSortedById() {
        return this.userService.getall();
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        return this.userService.add(user);
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return this.userService.updateProduct(id,updatedUser);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        return this.userService.delete(id);
    }
}

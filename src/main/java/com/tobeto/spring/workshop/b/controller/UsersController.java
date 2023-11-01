package com.tobeto.spring.workshop.b.controller;

import com.tobeto.spring.workshop.b.module.User;

import jakarta.annotation.PostConstruct;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    List<User> items = new ArrayList<>();

    @PostConstruct
    public void initializeUsers() {
        items.add(new User(1, "John", "john@john.com", "john123", "5343572837"));
        items.add(new User(2, "Michael", "michael@michael.com", "michael123", "5333572837"));
        items.add(new User(3, "Sophia", "sophia@sophia.com", "sophia123", "5343682837"));
        items.add(new User(4, "Emma", "emma@emma.com", "emma123", "55551234"));
        items.add(new User(5, "Oliver", "oliver@oliver.com", "oliver123", "55552345"));
        items.add(new User(6, "Ava", "ava@ava.com", "ava123", "55563456"));
        items.add(new User(7, "Liam", "liam@liam.com", "liam123", "55574567"));
        items.add(new User(8, "Isabella", "isabella@isabella.com", "isabella123", "55585678"));
        items.add(new User(9, "Sophie", "sophie@sophie.com", "sophie123", "55596789"));
        items.add(new User(10, "Lucas", "lucas@lucas.com", "lucas123", "55501010"));
    }


    @GetMapping("/getall")
    public List<User> getAllUsersSortedById() {
        return items.stream()
                .sorted(Comparator.comparingInt(User::getId))
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public String createUser(@RequestBody User user) {
        this.items.add(user);
        return user.getName() + " user added successfully.";
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        for (User user : items) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setPhone(updatedUser.getPhone());

                return "User updated! \nID: " + id + ", \nNew Information: \nName: " + user.getName() +
                        ", \nEmail: " + user.getEmail() + ", \nPassword: " + user.getPassword() + "\nPhone: " + user.getPhone();
            }
        }
        return "User not found!";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        for (User user : items) {
            if (user.getId() == id) {
                items.remove(user);
                return user.getName() + " user deleted successfully.";
            }
        }
        return "User not found.";
    }
}

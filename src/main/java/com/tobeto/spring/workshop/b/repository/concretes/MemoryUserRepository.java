package com.tobeto.spring.workshop.b.repository.concretes;

import com.tobeto.spring.workshop.b.module.User;
import com.tobeto.spring.workshop.b.repository.abstracts.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MemoryUserRepository implements UserRepository {

    List<User> users;

    public MemoryUserRepository() {
        this.users = new ArrayList<>();
        users.add(new User(1, "John", "john@john.com", "john123", "5343572837"));
        users.add(new User(2, "Michael", "michael@michael.com", "michael123", "5333572837"));
        users.add(new User(3, "Sophia", "sophia@sophia.com", "sophia123", "5343682837"));
        users.add(new User(4, "Emma", "emma@emma.com", "emma123", "55551234"));
        users.add(new User(5, "Oliver", "oliver@oliver.com", "oliver123", "55552345"));
        users.add(new User(6, "Ava", "ava@ava.com", "ava123", "55563456"));
    }

    @Override
    public String add(User user) {
        users.add(user);
        return user.getName() + " user added successfully.";
    }

    @Override
    public List<User> getall() {
        return users;
    }

    @Override
    public String delete(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                return user.getName() + " user deleted successfully.";
            }
        }
        return "User not found!";

    }

    @Override
    public String updateUser(int id, User updatedUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updatedUser.getName());
                user.setPhone(updatedUser.getPhone());
                user.setPassword(updatedUser.getPassword());
                user.setEmail(updatedUser.getEmail());
            }

            return "User updated! \nID: " + id + ", \nNew Information: \nName: " + user.getName() + ", \nEmail: " +
                    user.getEmail() + ", \nPassword: " + user.getPassword() + "\nPhone: " + user.getPhone();
        }

        return "User not found!";
    }


}

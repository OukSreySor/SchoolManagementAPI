package com.sreysor.school_management_api.Controller;

import com.sreysor.school_management_api.Entity.User;
import com.sreysor.school_management_api.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Get all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by id
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User newUser) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setStatus(newUser.getStatus());
        return userRepository.save(user);
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}

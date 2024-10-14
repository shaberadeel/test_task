package com.thinkon.exercise.UserService.controller;

import com.thinkon.exercise.UserService.model.User;
import com.thinkon.exercise.UserService.service.interfaces.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "User Management", description = "REST APIs for User Management")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Create a new user")
    public User createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    @Operation(summary = "Get list of all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a user by ID")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user")
    public User updateUser(@PathVariable Integer id, @Validated @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a user")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}

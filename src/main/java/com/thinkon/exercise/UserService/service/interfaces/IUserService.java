package com.thinkon.exercise.UserService.service.interfaces;

import com.thinkon.exercise.UserService.model.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(Integer id);

    User createUser(User user);

    User updateUser(Integer id, User updatedUser);

    void deleteUser(Integer id);
}

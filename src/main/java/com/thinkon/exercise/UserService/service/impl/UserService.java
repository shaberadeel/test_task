package com.thinkon.exercise.UserService.service.impl;

import com.thinkon.exercise.UserService.entity.UserEntity;
import com.thinkon.exercise.UserService.exception.ThinkOnGenericException;
import com.thinkon.exercise.UserService.exception.constants.ExceptionCodes;
import com.thinkon.exercise.UserService.exception.constants.ExceptionDetails;
import com.thinkon.exercise.UserService.mapper.UserMapper;
import com.thinkon.exercise.UserService.model.User;
import com.thinkon.exercise.UserService.repository.UserRepository;
import com.thinkon.exercise.UserService.service.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::map)
                .toList();
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.map(userRepository.findById(id)
                .orElseThrow(() -> new ThinkOnGenericException(ExceptionCodes.NOT_FOUND, ExceptionDetails.NOT_FOUND)));
    }

    @Override
    public User createUser(User user) {
        return userMapper.map(userRepository.save(userMapper.map(user)));
    }

    @Override
    public User updateUser(Integer id, User updatedUser) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ThinkOnGenericException(ExceptionCodes.NOT_FOUND, ExceptionDetails.NOT_FOUND));
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPhone(updatedUser.getPhone());
        return userMapper.map(userRepository.save(existingUser));
    }

    @Override
    public void deleteUser(Integer id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ThinkOnGenericException(ExceptionCodes.NOT_FOUND, ExceptionDetails.NOT_FOUND));
        userRepository.delete(user);
    }
}

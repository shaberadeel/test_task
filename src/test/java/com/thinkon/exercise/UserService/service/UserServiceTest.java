package com.thinkon.exercise.UserService.service;

import com.thinkon.exercise.UserService.entity.UserEntity;
import com.thinkon.exercise.UserService.exception.ThinkOnGenericException;
import com.thinkon.exercise.UserService.mapper.UserMapper;
import com.thinkon.exercise.UserService.model.User;
import com.thinkon.exercise.UserService.repository.UserRepository;
import com.thinkon.exercise.UserService.service.impl.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    private UserEntity userEntity;
    private User userModel;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);

        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("testuser");
        userEntity.setFirstName("John");
        userEntity.setLastName("Doe");
        userEntity.setEmail("test@example.com");

        userModel = new User();
        userModel.setUsername("testuser");
        userModel.setFirstName("John");
        userModel.setLastName("Doe");
        userModel.setEmail("test@example.com");
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.map(any(User.class))).thenReturn(userEntity);
        when(userMapper.map(any(UserEntity.class))).thenReturn(userModel);
        User createdUser = userService.createUser(userModel);
        assertNotNull(createdUser);
        assertEquals("testuser", createdUser.getUsername());
        verify(userRepository, times(1)).save(any(UserEntity.class));
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(1)).thenReturn(Optional.of(userEntity));
        when(userMapper.map(any(UserEntity.class))).thenReturn(userModel);

        User foundUser = userService.getUserById(1);

        assertNotNull(foundUser);
        assertEquals("testuser", foundUser.getUsername());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testGetUserById_UserNotFound() {
        when(userRepository.findById(1)).thenReturn(Optional.empty());

        assertThrows(ThinkOnGenericException.class, () -> userService.getUserById(1));
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.findById(1)).thenReturn(Optional.of(userEntity));
        doNothing().when(userRepository).delete(any());

        userService.deleteUser(1);

        verify(userRepository, times(1)).delete(any());
    }
}

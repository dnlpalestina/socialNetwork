package com.palestina.socialNetwork.controllers;

import com.palestina.socialNetwork.entities.User;
import com.palestina.socialNetwork.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1);
        user.setName("Test User");
        user.setScreen_name("New Test User Official 3");
        user.setLocation("Test Location, México");
        user.setUrl("https://developer.socialNetwork.com");
        user.setDescription("This is the description of a new test user");
        user.setProtectedProfile(true);
        user.setVerified(false);
    }

    @Test
    void getAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(user));
        assertNotNull(userController.getAllUsers());
    }

    @Test
    void getUserById() {
        when(userRepository.findById(user.getId())).thenReturn(Optional.ofNullable(user));
        assertNotNull(userController.getUserById(1));
    }

    @Test
    void createNewUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}
package com.palestina.socialNetwork.controllers;

import java.util.Optional;

import com.palestina.socialNetwork.entities.User;
import com.palestina.socialNetwork.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public Iterable<User> getAllUsers() {
    return userService.findAll();
  }

  @GetMapping("/users/{id}")
  public Optional<User> getUserById(@PathVariable("id") Integer id) {
    return userService.findById(id);
  }

  @PostMapping("/users")
  public User createNewUser(@RequestBody User user) {
    User newUser = userService.save(user);
    return newUser;
  }

  @PutMapping("/users/{id}")
  public User updateUser(
      @PathVariable("id") Integer id,
      @RequestBody User p) {
    Optional<User> userToUpdateOptional = userService.findById(id);
    if (!userToUpdateOptional.isPresent()) {
      return null;
    }
    User userToUpdate = userToUpdateOptional.get();
    if (p.getName() != null) {
      userToUpdate.setName(p.getName());
    }
    if (p.getScreen_name() != null) {
      userToUpdate.setScreen_name(p.getScreen_name());
    }
    if (p.getLocation() != null) {
      userToUpdate.setLocation(p.getLocation());
    }
    if (p.getUrl() != null) {
      userToUpdate.setUrl(p.getUrl());
    }
    if (p.getDescription() != null) {
      userToUpdate.setDescription(p.getDescription());
    }
    if (p.getProtectedProfile() != null) {
      userToUpdate.setProtectedProfile(p.getProtectedProfile());
    }
    if (p.getVerified() != null) {
      userToUpdate.setVerified(p.getVerified());
    }
    
    User updatedUser = userService.save(userToUpdate);
    return updatedUser;
  }

  @DeleteMapping("/users/{id}")
  public User deleteUser(@PathVariable("id") Integer id) {
    Optional<User> userToDeleteOptional = userService.findById(id);
    if (!userToDeleteOptional.isPresent()) {
      return null;
    }
    User userToDelete = userToDeleteOptional.get();
    userService.delete(userToDelete);
    return userToDelete;
  }
  
}

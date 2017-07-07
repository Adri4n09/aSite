package com.example.asite.service;

import com.example.asite.model.User;

public interface UserService {

    void deleteUser(User user);

    void updateUser(User user);

    Iterable<User> getAllUsers();

    User getUserById(String id);

    boolean userExists(User user);
}

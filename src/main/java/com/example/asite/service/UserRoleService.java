package com.example.asite.service;

import com.example.asite.model.UserRole;

public interface UserRoleService {

    void deleteUserRole(UserRole userRole);

    void updateUserRole(UserRole userRole);

    Iterable<UserRole> getAllUsers();

    UserRole getUserRoleById(Long id);

    boolean userRoleExists(UserRole userRole);
}

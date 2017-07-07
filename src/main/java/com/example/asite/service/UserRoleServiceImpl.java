package com.example.asite.service;

import com.example.asite.model.UserRole;
import com.example.asite.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public void deleteUserRole(UserRole userRole) {
        userRoleRepository.delete(userRole);
    }

    @Override
    public void updateUserRole(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public Iterable<UserRole> getAllUsers() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole getUserRoleById(Long id) {
        return userRoleRepository.findOne(id);
    }

    @Override
    public boolean userRoleExists(UserRole userRole) {
        return userRoleRepository.exists(userRole.getUserRoleId());
    }
}

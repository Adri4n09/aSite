package com.example.asite.controllers;

import com.example.asite.model.User;
import com.example.asite.model.UserRole;
import com.example.asite.service.UserRoleService;
import com.example.asite.service.UserService;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addRandom", method = RequestMethod.POST)
    public ResponseEntity addRandom() {
        User user = new User();
        user.setUsername(UUID.randomUUID().toString().substring(0,35));
        user.setPassword(UUID.randomUUID().toString().substring(0,35));
        user.setEnabled(1);
        userService.updateUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        if (userService.userExists(user)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getRoles", method = RequestMethod.GET)
    public ResponseEntity<Iterable<UserRole>> getRoles() {
        return new ResponseEntity<>(userRoleService.getAllUsers(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public ResponseEntity addUserRole(@RequestBody UserRole userRole) {
        userRoleService.updateUserRole(userRole);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/getRandom", method = RequestMethod.GET)
    public ResponseEntity<User> getRandomUser() {
        Iterator<User> userIterator = userService.getAllUsers().iterator();
        List<User> users = IteratorUtils.toList(userIterator);
        return new ResponseEntity<>(users.get(0), HttpStatus.OK);
    }

}

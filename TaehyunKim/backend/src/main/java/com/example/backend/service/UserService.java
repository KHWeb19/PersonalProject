package com.example.backend.service;

import com.example.backend.entity.Role;
import com.example.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    User getUser(String username);
    List<User> getUsers();
    List<Role> getRoles();
    void addRoleToUser(String username, String rolename);
    Optional<User> getUserByEmail(String email);
    Optional<User> getUserByUserName(String username);
}

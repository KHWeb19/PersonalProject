package com.example.backend.service;

import com.example.backend.entity.Role;
import com.example.backend.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    List<User> getUsers();
    List<Role> getRoles();
}

package com.example.bbw_test.services;

import java.util.List;

import com.example.bbw_test.models.entities.Role;
import com.example.bbw_test.models.entities.User;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(String username);
    List<User> getUsers();
}

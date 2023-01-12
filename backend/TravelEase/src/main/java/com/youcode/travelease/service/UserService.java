package com.youcode.travelease.service;

import com.youcode.travelease.entity.Role;
import com.youcode.travelease.entity.User;

import java.util.List;

public interface UserService {

    User saveUSer( User user);
    Role saveRole( Role role);
    void addRoleToUSer(String username, String roleName);
    User getUser(String username);
    List<User> getUSers();

//    UserDto register ( UserDto userDto );
//
//    String login ( LoginForm loginForm );
}

package com.youcode.travelease.service;

import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.Role;
import com.youcode.travelease.entity.User;

import java.util.List;

public interface UserService {

    UserDto register ( UserDto userDto );

    String login ( LoginForm loginForm );
}

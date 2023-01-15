package com.youcode.travelease.service;

import com.youcode.travelease.dto.HotelDto;
import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.Role;
import com.youcode.travelease.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserService {

    UserDetails loadUserByUsername( String email);
    User register ( UserDto userDto );
    String login ( LoginForm loginForm );

}

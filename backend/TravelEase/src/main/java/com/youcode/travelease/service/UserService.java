package com.youcode.travelease.service;

import com.youcode.travelease.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User findUserById( Long id);
}

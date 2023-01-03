package com.youcode.travelease.service.implementation;

import com.youcode.travelease.entity.User;
import com.youcode.travelease.repository.UserRepository;
import com.youcode.travelease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User findUserById ( Long id ) {
        Optional<User> userOptional =  userRepository.findById ( id );
        if (userOptional.isPresent ()){
            return userOptional.get ();
        } else {
            return null;
        }
    }
}

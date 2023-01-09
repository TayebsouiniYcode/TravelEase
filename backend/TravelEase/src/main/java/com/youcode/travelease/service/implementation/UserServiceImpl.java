package com.youcode.travelease.service.implementation;


import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.Role;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.repository.RoleRepository;
import com.youcode.travelease.repository.UserRepository;
import com.youcode.travelease.service.UserService;
import com.youcode.travelease.util.ResponseMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service @Transactional @Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto register ( UserDto userDto ) {
        User user = new User (  );
        user.setFirstname ( userDto.getFirstname () );
        user.setLastname ( userDto.getLastname () );
        user.setEmail ( userDto.getEmail () );
        user.setPhone ( userDto.getPhone () );
        user.setPassword ( userDto.getPassword () );

        try {
            this.userRepository.save ( user );
            return userDto;
        } catch (Exception e ) {
            return null;
        }

    }

    @Override
    public String login ( LoginForm loginForm ) {
        Optional<User> userOptional = this.userRepository.findByUsername ( loginForm.getUsername () );
        if (userOptional.isPresent ()) {
            if (userOptional.get ().getPassword () == loginForm.getPassword ()) {
                return "success";
            } else {
                return "Mot de passe incorrect";
            }
        } else {
            return "username introvable";
        }
    }
}

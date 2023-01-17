package com.youcode.travelease.service.implementation;


import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.repository.UserRepository;
import com.youcode.travelease.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername ( String email ) {
        User user = userRepository.findByEmail ( email );
        if (user == null ) {
            log.error ( "User not found" );
            throw  new UsernameNotFoundException ( "User not found" );
        } else {
            log.info ( "User found in database : {} ", email );
        }
        Collection< SimpleGrantedAuthority > authorities = new ArrayList <> (  );
        user.getRoles ().forEach ( role -> {
            authorities.add ( new SimpleGrantedAuthority ( role.getRole_name () ) );
        });
        return new org.springframework.security.core.userdetails.User (user.getEmail (), user.getPassword (), authorities  );
    }

    @Override
    public User register ( UserDto userDto ) {
        User user = new User (  );
        user.setFirstname ( userDto.getFirstname () );
        user.setLastname ( userDto.getLastname () );
        user.setEmail ( userDto.getEmail () );
        user.setPassword ( userDto.getPassword () );
        user.setPhone ( userDto.getPhone () );
        user.setUsername ( userDto.getUsername () );
        return userRepository.save ( user );
    }

    @Override
    public String login ( LoginForm loginForm ) {
        return null;
    }

    @Override
    public Optional < User > findByUsername ( String username ) {
        return userRepository.findByUsername ( username );
    }

    @Override
    public User findByEmail ( String email ) {
        return userRepository.findByEmail ( email );
    }
}

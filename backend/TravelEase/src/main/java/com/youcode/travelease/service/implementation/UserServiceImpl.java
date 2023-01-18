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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

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
        if (userDto.getFirstname () != null && !userDto.getFirstname ().isEmpty ()) {
            if (userDto.getLastname () != null && !userDto.getLastname ().isEmpty ()) {
                if (userDto.getEmail () != null && !userDto.getEmail ().isEmpty ()) {
                    // TODO Test for optional email if exists or not
                    if ( userDto.getPassword () != null
                            && !userDto.getPassword ().isEmpty ()) {
                            try {
                                user.setFirstname ( userDto.getFirstname () );
                                user.setLastname ( userDto.getLastname () );
                                user.setEmail ( userDto.getEmail () );
                                user.setPassword ( userDto.getPassword () );
                                user.setPhone ( userDto.getPhone () );
                                user.setUsername ( userDto.getUsername () );

                                Role role = getRoleByName ( "ROLE_USER" );
                                user.changeRole ( role );
                                return userRepository.save ( user );
                            } catch (Exception e) {
                                ResponseMessage message = new ResponseMessage ();
                                message.setMessage ( "Exception : " + e.getMessage () );
                                user.setMessage ( message );
                                return user;
                            }
                    } else {

                        ResponseMessage message = new ResponseMessage ();
                        message.setMessage ( "Password null or empty" );
                        user.setMessage ( message );
                        return user;

                    }
                } else {

                    ResponseMessage message = new ResponseMessage ();
                    message.setMessage ( "Email null or empty" );
                    user.setMessage ( message );
                    return user;
                }
            } else {
                // lastname is null or empty

                ResponseMessage message = new ResponseMessage ();
                message.setMessage ( "Lastname null or empty" );
                user.setMessage ( message );
                return user;
            }
        } else {

            ResponseMessage message = new ResponseMessage ();
            message.setMessage ( "firstname" );
            user.setMessage ( message );
            return user;
        }




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

    @Override
    public List < User > getAllUsers ( ) {
        return this.userRepository.findAll ();
    }

    @Override
    public Role getRoleByName ( String role_name ) {
        return this.roleRepository.getRoleByName ( role_name );
    }

    @Override
    public User save ( User user ) {
        return this.userRepository.save ( user );
    }
}

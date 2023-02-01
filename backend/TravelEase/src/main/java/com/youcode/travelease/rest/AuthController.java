package com.youcode.travelease.rest;

import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.security.JwtUtils;
import com.youcode.travelease.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin()
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @PostMapping("/login")
    public String authenticate( @RequestBody LoginForm loginForm) {
        authenticationManager.authenticate (
                new UsernamePasswordAuthenticationToken ( loginForm.getUsername (), loginForm.getPassword () )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername ( loginForm.getUsername ( ) );
        return jwtUtils.generateToken ( userDetails );
    }

    @PostMapping("/register")
    public ResponseEntity< User > register( @RequestBody UserDto user){
        return ResponseEntity.ok (userService.register (user));
    }
}

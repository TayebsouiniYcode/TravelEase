package com.youcode.travelease.rest;

import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.security.JwtUtils;
import com.youcode.travelease.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4051")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody LoginForm loginForm) {
        authenticationManager.authenticate (
                new UsernamePasswordAuthenticationToken ( loginForm.getUsername (), loginForm.getPassword () )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername ( loginForm.getUsername ( ) );
        if (userDetails != null ) {
            return ResponseEntity.ok ( jwtUtils.generateToken ( userDetails ));
        }
        return ResponseEntity.status (400).body ("some error has accurent");
    }

    @PostMapping("/register")
    public ResponseEntity< User > register( @RequestBody UserDto user){
        return ResponseEntity.ok (userService.register (user));
    }
}

package com.youcode.travelease.rest;

import com.youcode.travelease.dto.LoginForm;
import com.youcode.travelease.dto.UserDto;
import com.youcode.travelease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4051")
public class AuthController {
//    @Autowired
//    private UserService userService;

//    @PostMapping("/register")
//    public UserDto register(@RequestBody UserDto userDto) {
//        return this.userService.register(userDto);
//    }
//
//    @PostMapping("/login")
//    public String login( @RequestBody LoginForm loginForm ){
//        return this.userService.login(loginForm);
//    }
}

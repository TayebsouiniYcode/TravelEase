package com.youcode.travelease.rest;

import com.youcode.travelease.dto.UserUpdateDto;
import com.youcode.travelease.entity.Role;
import com.youcode.travelease.entity.User;
import com.youcode.travelease.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("utilisateurs")
    public List< User > getAllUsers() {
        return this.userService.getAllUsers();
    }

    @PutMapping("/utilisateur/apdate")
    public User updateUser(@RequestBody UserUpdateDto userUpdateDto){
        System.out.println ("this is " + userUpdateDto.toString () );
        Role role = this.userService.getRoleByName ( userUpdateDto.getRole_name () );
        User user = this.userService.findByEmail ( userUpdateDto.getEmail () );

        if (user != null && !user.equals ( new User (  ) ) && role != null && !role.equals ( new Role (  ) ) ){
            user.changeRole ( role );
            user.setFirstname ( userUpdateDto.getFirstname ( ) );
            user.setLastname ( userUpdateDto.getLastname ( ) );
            return this.userService.save ( user );
        }
        return null;
    }
}

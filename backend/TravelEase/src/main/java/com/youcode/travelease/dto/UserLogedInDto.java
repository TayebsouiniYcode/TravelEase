package com.youcode.travelease.dto;


import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

public class UserLogedInDto implements Serializable {
    private  String username;
    private  String email;
    private Collection roles;
    private  String token;

    public UserLogedInDto ( ) {
    }

    public UserLogedInDto ( String username , String email , Collection roles , String token ) {
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.token = token;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername ( String username ) {
        this.username = username;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail ( String email ) {
        this.email = email;
    }

    public Collection getRoles ( ) {
        return roles;
    }

    public void setRoles ( Collection roles ) {
        this.roles = roles;
    }

    public String getToken ( ) {
        return token;
    }

    public void setToken ( String token ) {
        this.token = token;
    }
}

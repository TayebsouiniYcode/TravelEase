package com.youcode.travelease.dto;

import com.youcode.travelease.util.ResponseMessage;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.travelease.entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String password;
    private final String username;
    private final String email;
    private final String phone;
    private final String lastname;
    private final String firstname;
    private final String responseMessage;
}
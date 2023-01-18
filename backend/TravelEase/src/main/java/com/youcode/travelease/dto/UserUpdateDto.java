package com.youcode.travelease.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserUpdateDto {
    public String email;
    public String firstname;
    public String lastname;
    public String role_name;
}

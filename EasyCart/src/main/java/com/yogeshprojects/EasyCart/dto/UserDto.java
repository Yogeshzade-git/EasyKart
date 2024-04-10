package com.yogeshprojects.EasyCart.dto;

import com.yogeshprojects.EasyCart.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private String name;
    private Long id;
    private String email;
    private UserRole userRole;
}

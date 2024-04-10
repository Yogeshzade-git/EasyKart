package com.yogeshprojects.EasyCart.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String name;
    private String password;
    private String email;
}

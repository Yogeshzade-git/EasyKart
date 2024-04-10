package com.yogeshprojects.EasyCart.services.auth;

import com.yogeshprojects.EasyCart.dto.SignupRequest;
import com.yogeshprojects.EasyCart.dto.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
    Boolean hasUserWithEmail(String email);
}

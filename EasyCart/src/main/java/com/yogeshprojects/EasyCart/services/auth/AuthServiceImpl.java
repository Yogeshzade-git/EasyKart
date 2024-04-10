package com.yogeshprojects.EasyCart.services.auth;

import com.yogeshprojects.EasyCart.dto.SignupRequest;
import com.yogeshprojects.EasyCart.dto.UserDto;
import com.yogeshprojects.EasyCart.entity.User;
import com.yogeshprojects.EasyCart.enums.UserRole;
import com.yogeshprojects.EasyCart.repository.UserRespository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserDto createUser(SignupRequest signupRequest){
            User user = new User();
            user.setEmail(signupRequest.getEmail());
            user.setName(signupRequest.getName());
            user.setRole(UserRole.CUSTOMER);
            user.setPassword(new BCryptPasswordEncoder().encode(signupRequest.getPassword()));
            User createdUser = userRespository.save(user);

            UserDto userDto = new UserDto();
            userDto.setId(createdUser.getId());

            return userDto;
    }

    public Boolean hasUserWithEmail(String email){
        return userRespository.findFirstByEmail(email).isPresent();
    }

    @PostConstruct
    public void createAdminAccount(){
        User adminAccount = userRespository.findByRole(UserRole.ADMIN);
        if(null == adminAccount){
            User user = new User();
            user.setEmail("admin@gmail.com");
            user.setName("admin");
            user.setRole(UserRole.ADMIN);
            user.setRole(UserRole.ADMIN);
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRespository.save(user);
        }
    }
}

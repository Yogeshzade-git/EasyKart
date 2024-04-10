package com.yogeshprojects.EasyCart.repository;

import com.yogeshprojects.EasyCart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
}

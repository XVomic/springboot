package com.xxc.learnboot.service;

import com.xxc.learnboot.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    User insert(User user);

    User findByUsername(String username);

    Optional<User> findById(int id);

}

package com.xxc.learnboot.service;

import com.xxc.learnboot.entity.User;

import java.util.Optional;

public interface UserService {

    public User insert(User user);

    public User findByUsername(String username);

    public Optional<User> findById(int id);

}

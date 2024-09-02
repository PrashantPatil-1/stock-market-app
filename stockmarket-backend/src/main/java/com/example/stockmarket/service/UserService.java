package com.example.stockmarket.service;

import com.example.stockmarket.model.User;

public interface UserService {
    void registerUser(User user);
    User findUserByUsername(String username);
}

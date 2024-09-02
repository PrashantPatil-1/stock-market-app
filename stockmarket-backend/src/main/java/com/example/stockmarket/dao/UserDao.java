package com.example.stockmarket.dao;

import com.example.stockmarket.model.User;

public interface UserDao {
    void insertUser(User user);
    User getUserByUsername(String username);
}

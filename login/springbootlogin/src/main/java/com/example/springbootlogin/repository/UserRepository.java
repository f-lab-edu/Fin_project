package com.example.springbootlogin.repository;

import com.example.springbootlogin.model.User;

public interface UserRepository {

    void addUser(User user);

    User getUserById(String id);
}
package com.example.springbootlogin.service;

import com.example.springbootlogin.model.User;
import com.example.springbootlogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String id, String password) {
        User user = userRepository.getUserById(id);
        return user != null && user.getPassword().equals(password);
    }

    public void registerUser(User user) {
        userRepository.addUser(user);
    }
}
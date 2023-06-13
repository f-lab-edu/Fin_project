// UserService.java
package com.login.services;

import com.login.models.User;
import com.login.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //인증
    public boolean authenticate(String id, String password) {
        User user = userRepository.getUserByid(id);
        return user != null && user.getPassword().equals(password);
    }
    //추가
    public void registerUser(User user) {
        userRepository.addUser(user);
    }
}

// UserRepository.java
package com.login.repositories;


import com.login.models.User;

public interface UserRepository {
    void addUser(User user);
    User getUserByid(String id);
}

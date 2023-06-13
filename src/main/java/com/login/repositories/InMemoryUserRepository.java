// InMemoryUserRepository.java
package com.login.repositories;


import com.login.models.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    //hashmap 타입의 users변수는  Map<String,User> 형식으로 값을 넣을수있다
    //(ket는 String, value는 User의 객체)
    private final Map<String, User> users = new HashMap<>();

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public User getUserByid(String id) {
        return users.get(id);
    }
}

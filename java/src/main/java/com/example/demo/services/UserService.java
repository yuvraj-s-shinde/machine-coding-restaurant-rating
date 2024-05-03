package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.repositories.IUserRepository;

public class UserService {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createUser(String name) {
        User u = new User(name);
        User user = userRepository.save(u);
        return user;
    }
}

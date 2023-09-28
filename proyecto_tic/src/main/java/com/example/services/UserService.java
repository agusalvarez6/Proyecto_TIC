package com.example.services;

import com.example.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}

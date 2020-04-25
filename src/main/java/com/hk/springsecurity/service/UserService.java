package com.hk.springsecurity.service;

import com.hk.springsecurity.domain.User;
import com.hk.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User add(User user){
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }
}

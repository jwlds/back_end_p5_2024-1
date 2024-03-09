package com.puccampinas.back_end_pi5.services.auth;


import com.puccampinas.back_end_pi5.domain.user.User;
import com.puccampinas.back_end_pi5.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> allUsers() {
        return userRepository.findAll();
    }

    public Optional<User> singleUser(long userId) {
        return userRepository.findById(userId);
    }

}

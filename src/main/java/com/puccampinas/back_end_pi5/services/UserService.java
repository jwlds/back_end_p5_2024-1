package com.puccampinas.back_end_pi5.services;


import com.puccampinas.back_end_pi5.domain.user.User;
import com.puccampinas.back_end_pi5.repositories.UserRepository;
import org.bson.types.ObjectId;
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

    public Optional<User> singleUser(String userId) {
        ObjectId objectId = new ObjectId(userId);
        return userRepository.findById(objectId);
    }

}

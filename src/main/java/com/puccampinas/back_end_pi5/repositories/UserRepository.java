package com.puccampinas.back_end_pi5.repositories;

import com.puccampinas.back_end_pi5.domain.user.User;
import org.bson.types.ObjectId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    UserDetails findUserByLogin(String login);

    UserDetails findUserById(long id);
}

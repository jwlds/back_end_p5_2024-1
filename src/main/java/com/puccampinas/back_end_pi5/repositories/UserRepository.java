package com.puccampinas.back_end_pi5.repositories;

import com.puccampinas.back_end_pi5.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findUserByLogin(String login);

    UserDetails findUserById(long id);
}

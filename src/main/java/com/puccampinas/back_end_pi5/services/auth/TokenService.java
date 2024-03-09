package com.puccampinas.back_end_pi5.services.auth;

import com.puccampinas.back_end_pi5.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

public String generateToken(User user) {
    try {
        var algorithm = Algorithm.HMAC256("${env.HASHCODE}");
        return JWT.create()
                .withIssuer("API PROJECT 5")
                .withSubject(String.valueOf(user.getId()))
                .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                .sign(algorithm);
    } catch (JWTCreationException exception){
        throw new RuntimeException("error generating jwt token", exception);
    }
}


    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256("${env.HASHCODE}");
            return JWT.require(algorithm)
                    .withIssuer("API PROJECT 5")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Invalid or expired JWT token!");
        }
    }
}

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
        var algorithm = Algorithm.HMAC256("123456");
        return JWT.create()
                .withIssuer("API EASY AGRO")
                .withSubject(String.valueOf(user.getId()))
                .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                .sign(algorithm);
    } catch (JWTCreationException exception){
        throw new RuntimeException("erro ao gerar token jwt", exception);
    }
}


    public String getSubject(String tokenJWT) {
        try {
            var algorithm = Algorithm.HMAC256("123456");
            return JWT.require(algorithm)
                    .withIssuer("API EASY AGRO")
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException exception) {
            throw new RuntimeException("Token JWT inválido ou expirado!");
        }
    }
}

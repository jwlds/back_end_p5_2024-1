package com.puccampinas.back_end_pi5.controllers;

import com.puccampinas.back_end_pi5.domain.user.User;
import com.puccampinas.back_end_pi5.services.auth.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@SecurityRequirement(name = "bearer-key")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }



//    @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader
//    String jwtToken = authorizationHeader.replace("Bearer ", "");
//    int userId = Integer.parseInt(tokenService.getSubject(jwtToken));
//


}

package com.puccampinas.back_end_pi5.controllers.auth;


import com.puccampinas.back_end_pi5.domain.user.User;
import com.puccampinas.back_end_pi5.dtos.auth.AuthenticationDTO;
import com.puccampinas.back_end_pi5.dtos.auth.JWTokenDTO;
import com.puccampinas.back_end_pi5.services.auth.TokenService;
import com.puccampinas.back_end_pi5.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;



    @PostMapping
    public ResponseEntity singIn(@RequestBody @Valid AuthenticationDTO credential){
        try {
            var tokenAuthentication = new UsernamePasswordAuthenticationToken(credential.login(),credential.password());
            var authentication = authenticationManager.authenticate(tokenAuthentication);
            var user = (User) authentication.getPrincipal();

            System.out.println(user.getId());
            var tokenJWT = tokenService.generateToken(user);
            return ResponseEntity.ok(new JWTokenDTO(tokenJWT));
        } catch(BadCredentialsException err) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

//    @PatchMapping("/password/{id}")
//    public ResponseEntity<ApiResponse<String>> updatePassword(@PathVariable int id, @RequestBody String password) {
//        String updatedPassword = userService.updatePassword(password, id);
//        ApiResponse<String> response = new ApiResponse<>(HttpStatus.OK.value(), "Password updated successfully", updatedPassword);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

}


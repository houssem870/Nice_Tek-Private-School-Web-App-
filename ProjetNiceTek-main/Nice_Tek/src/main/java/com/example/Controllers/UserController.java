package com.example.Controllers;

import com.example.Security.Request.LoginForm;
import com.example.Security.Request.SignUpForm;
import com.example.Entities.UserTest;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserTest user){
        return userService.addUser(user);
    }
    @PostMapping("/auth/signUp")
    public ResponseEntity<?> SignUp(@RequestBody SignUpForm signUpForm){
        return userService.signUp(signUpForm);
    }

    @PostMapping("/auth/signIn")
    public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm){
        return userService.signIn(loginForm);
    }

}

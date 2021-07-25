package com.example.Controllers;

import com.example.Entities.User;
import com.example.Security.Request.LoginForm;
import com.example.Security.Request.SignUpForm;
import com.example.Entities.UserTest;
import com.example.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasAnyAuthority({'Admin','Etudiant'})")
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
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @DeleteMapping("/deleteByUserName")
    public ResponseEntity<?> deleteByUserName(@RequestParam String userName){
        return userService.deleteByUserName(userName);
    }
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @PutMapping("/updateById")
    public ResponseEntity<?> updateUser(@RequestParam int id, @RequestBody User updatedUser){
        return userService.updateUser(id,updatedUser);
    }
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @GetMapping("/getByEmail")
    public ResponseEntity<?> getByEmail(@RequestParam String email){
        return userService.getByEmail(email);
    }
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @GetMapping("/getByUserName")
    public ResponseEntity<?> getByUserName(@RequestParam String userName){
        return userService.getByUserName(userName);
    }
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam int id){
        return userService.getById(id);
    }
    @PreAuthorize("hasAnyAuthority({'Admin'})")
    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.ACCEPTED);
    }
}

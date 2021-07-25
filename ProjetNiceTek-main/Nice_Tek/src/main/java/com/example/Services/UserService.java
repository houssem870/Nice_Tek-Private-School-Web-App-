package com.example.Services;

import com.example.Entities.*;
import com.example.Security.Request.LoginForm;
import com.example.Security.Request.SignUpForm;
import com.example.Security.Response.SignInResponse;
import com.example.utils.ErrorModel;
import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.Repository.RoleNameRepository;
import com.example.Repository.UserRepository;
import com.example.Security.JwtUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Configuration
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleNameRepository roleNameRepository;
    @Autowired
    JwtUtils jwtUtils ;
    @Autowired
    AuthenticationManager authenticationManager;

    public ResponseEntity<?> addUser(UserTest userTest){



        List<RolesName> rolesNameList=new ArrayList<>();
        for(Role r :userTest.getRoleList())
            rolesNameList.add(roleNameRepository.findByName(r).get());


        User user=new User();
        if (userRepository.findByUserName(userTest.getUserName()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel("user name is used"),HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(userTest.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST);
        }
        if(!isValidEmailAddress(userTest.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }
        user.setAdress(userTest.getAdress());
        user.setDate_Creation(userTest.getDate_Creation());
        user.setEmail(userTest.getEmail());
        if (userTest.getFirstName().length()==0){
            return  new ResponseEntity<>(new ErrorModel("UserName is empty"),HttpStatus.BAD_REQUEST); }
        user.setFirstName(userTest.getFirstName());
        if (userTest.getLastName().length()==0){
            return  new ResponseEntity<>(new ErrorModel("LastName is empty"),HttpStatus.BAD_REQUEST); }
        user.setLastName(userTest.getLastName());
        user.setGender(userTest.getGender());

        user.setTelephone(userTest.getTelephone());
        if (userTest.getPassWord().length()<5){
            return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
        String password = passwordEncoder().encode(userTest.getPassWord());
        user.setPassWord(password);

        user.setUserName(userTest.getUserName());
        user.setRole_name(rolesNameList);


        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    public ResponseEntity<?> signUp (SignUpForm signUpForm){
        String role=signUpForm.getRole_Name();

        if (userRepository.findByUserName(signUpForm.getUserName()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel("user name is used"),HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(signUpForm.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST);
        }
        if(!isValidEmailAddress(signUpForm.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }
        if(role.equals("Etudiant")){
            Etudiant etudiant = new Etudiant() ;
            if (signUpForm.getFirstName().length()==0){
                return  new ResponseEntity<>(new ErrorModel("UserName is empty"),HttpStatus.BAD_REQUEST); }
            etudiant.setFirstName(signUpForm.getFirstName());
            if (signUpForm.getLastName().length()==0){
                return  new ResponseEntity<>(new ErrorModel("LastName is empty"),HttpStatus.BAD_REQUEST); }
            etudiant.setLastName(signUpForm.getLastName());
            etudiant.setAdress(signUpForm.getAdress());
            etudiant.setEmail(signUpForm.getEmail());
            etudiant.setUserName(signUpForm.getUserName());
            etudiant.setTelephone(signUpForm.getTelephone() );
            etudiant.setGender(signUpForm.getGender());
            LocalDate today = LocalDate.now();
            etudiant.setDate_Creation(today);
            if (signUpForm.getPassWord().length()<5){
                return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
            String password = passwordEncoder().encode(signUpForm.getPassWord());
            etudiant.setPassWord(password);
            List<RolesName> rolesNameList=new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Etudiant).get());
            etudiant.setRole_name(rolesNameList);
            userRepository.save(etudiant);
            return new ResponseEntity<>(etudiant,HttpStatus.OK);


        }
        if (role.equals("Professionel")) {

            Professionel professionel = new Professionel();
            professionel.setFirstName(signUpForm.getFirstName());
            professionel.setLastName(signUpForm.getLastName());
            professionel.setAdress(signUpForm.getAdress());
            professionel.setEmail(signUpForm.getEmail());
            LocalDate today = LocalDate.now();
            professionel.setDate_Creation(today);
            professionel.setTelephone(signUpForm.getTelephone());
            professionel.setGender(signUpForm.getGender());
            String password = passwordEncoder().encode(signUpForm.getPassWord());
            professionel.setPassWord(password);
            List<RolesName> rolesNameList = new ArrayList<>();
            rolesNameList.add(roleNameRepository.findByName(Role.Professionel).get());
            professionel.setRole_name(rolesNameList);
            userRepository.save(professionel);
            return new ResponseEntity<>(professionel, HttpStatus.OK);


        }
        return new ResponseEntity<>(new ErrorModel("Role is empty"),HttpStatus.BAD_REQUEST);



    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public ResponseEntity<?> signIn ( LoginForm loginform) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginform.getUserName(), loginform.getPassWord()));


        String jwt = jwtUtils.generateToken(loginform.getUserName());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new SignInResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()),HttpStatus.ACCEPTED);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ResponseEntity<?> deleteByUserName(String userName){
        if(!userRepository.findByUserName(userName).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        int id=userRepository.findByUserName(userName).get().getId();
        userRepository.deleteById(id);
        return new ResponseEntity<>(new ErrorModel("User Deleted"),HttpStatus.OK);

    }
    public ResponseEntity<?> getByUserName(String userName){
        if(!userRepository.findByUserName(userName).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        Optional<User> user=userRepository.findByUserName(userName);
        return new ResponseEntity<>(user.get(),HttpStatus.OK);

    }
    public ResponseEntity<?> getById(int id){
        if(!userRepository.findById(id).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        User user=userRepository.findById(id).get();
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    public ResponseEntity<?> getByEmail(String email){
        if(!userRepository.findByEmail(email).isPresent())
            return new ResponseEntity<>(new ErrorModel("User Not Found"),HttpStatus.BAD_REQUEST);
        User user=userRepository.findByEmail(email).get();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    public ResponseEntity<?> updateUser(int id, User updatedUser) {
        Optional<User> UserOptional = userRepository.findById(id);
        if(!UserOptional.isPresent())
            return new ResponseEntity<>(new ErrorModel("wrong user id "),HttpStatus.BAD_REQUEST);

        User databaseUser = UserOptional.get();

        if(updatedUser.getFirstName() != null)
            if (updatedUser.getFirstName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("wrong user name"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setFirstName(updatedUser.getFirstName());

        if(updatedUser.getLastName() != null)
            if (updatedUser.getLastName().length() < 3)
                return new ResponseEntity<>(new ErrorModel("Invalid LastName"),HttpStatus.BAD_REQUEST);
            else
                databaseUser.setLastName(updatedUser.getLastName());

        if (updatedUser.getPassWord().length()<5){
            return  new ResponseEntity<>(new ErrorModel("Short PassWord"),HttpStatus.BAD_REQUEST); }
        String password = passwordEncoder().encode(updatedUser.getPassWord());
        databaseUser.setPassWord(password);


        if (userRepository.findByEmail(updatedUser.getEmail()).isPresent()){
            return  new ResponseEntity<>(new ErrorModel(" Email is  used"),HttpStatus.BAD_REQUEST); }

        if(!isValidEmailAddress(updatedUser.getEmail())){
            return  new ResponseEntity<>(new ErrorModel("Invalid email"),HttpStatus.BAD_REQUEST);
        }
        databaseUser.setEmail(updatedUser.getEmail());



        userRepository.save(databaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public List<User>        getAll(){
        return  userRepository.findAll();

    }



}
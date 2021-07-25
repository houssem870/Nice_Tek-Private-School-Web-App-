package com.example.Security.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SignUpForm {
    private Long id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private String telephone ;
    private String gender ;
    private LocalDate date_Creation ;
    private String userName ;
    private String passWord ;
    private String adress;
    private String role_Name;

}

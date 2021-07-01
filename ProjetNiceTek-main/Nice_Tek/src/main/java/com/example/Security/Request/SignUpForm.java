package com.example.Security.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class SignUpForm {
    private Long id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private int telephone ;
    private String gender ;
    private Date last_Connection ;
    private Date date_Creation ;
    private String userName ;
    private String passWord ;
    private String adress;
    private String role_Name;

}

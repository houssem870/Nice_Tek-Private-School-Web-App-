package com.example.Security.Request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SignUpForm {
    private Long id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private String telephone ;
    private String gender ;
    private LocalDate dateCreation ;
    private String username ;
    private String password ;
    private String adress;
    private String role;

}

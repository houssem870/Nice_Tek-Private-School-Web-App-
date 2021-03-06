package com.example.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserTest {

    private String firstName ;
    private String lastName;
    private String email ;
    private String telephone ;
    private String gender ;

    private LocalDate date_Creation ;
    private String userName ;
    private String passWord ;
    private String adress;
    private List<Role> roleList=new ArrayList<>();
}

package com.example.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserTest {

    private String firstName ;
    private String lastName;
    private String email ;
    private int telephone ;
    private String gender ;
    private  Date last_Connection ;
    private Date date_Creation ;
    private String userName ;
    private String passWord ;
    private String adress;
    private List<Role> roleList=new ArrayList<>();
}

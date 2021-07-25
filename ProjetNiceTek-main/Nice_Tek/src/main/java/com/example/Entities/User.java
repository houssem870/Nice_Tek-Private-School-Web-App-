package com.example.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String firstName ;
    private String lastName;
    private String email ;
    private String telephone ;
    private String gender ;
    private LocalDate date_Creation ;
    private String userName ;
    private String passWord ;
    private String adress;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RolesName> role_name = new ArrayList<RolesName>();
    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE})
    private List<Quest_Pro> quest_pros=new ArrayList<>();



}
package com.example.Entities;
import lombok.NoArgsConstructor;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@NoArgsConstructor
@DiscriminatorValue("Admin")
public class Admin extends User {
    private Long id ;
}
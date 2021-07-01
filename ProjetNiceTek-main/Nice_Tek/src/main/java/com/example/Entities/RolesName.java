package com.example.Entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
@JsonDeserialize(as = RolesName.class)
@Entity
@Getter
@Setter
public class RolesName implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    @Enumerated(EnumType.STRING)
    @NaturalId
    private Role name;

    @Override
    public String getAuthority() {
        return name.toString();
    }
}

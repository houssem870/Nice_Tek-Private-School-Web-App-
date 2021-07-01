package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.Role;
import com.example.Entities.RolesName;

import java.util.Optional;

public interface RoleNameRepository extends JpaRepository<RolesName,Integer> {

    Optional<RolesName> findByName(Role name);
}

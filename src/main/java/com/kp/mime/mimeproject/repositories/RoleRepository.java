package com.kp.mime.mimeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}

package com.kp.mime.mimeproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
    List<Role> findByIdIn(List<Integer> idList);
}

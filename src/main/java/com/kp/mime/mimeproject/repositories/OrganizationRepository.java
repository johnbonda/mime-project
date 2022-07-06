package com.kp.mime.mimeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
    
}

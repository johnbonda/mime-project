package com.kp.mime.mimeproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Integer>{
    List<Organization> findByIdIn(List<Integer> idList);
}

package com.kp.mime.mimeproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Mime;

public interface MimeRepository extends JpaRepository<Mime, Integer>, MimeRepositoryCustom {
    public List<Mime> findByLastName(String lastName);    
}

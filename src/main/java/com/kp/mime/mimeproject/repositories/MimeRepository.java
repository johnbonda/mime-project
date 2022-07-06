package com.kp.mime.mimeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Mime;

public interface MimeRepository extends JpaRepository<Mime, Integer>{
    
}

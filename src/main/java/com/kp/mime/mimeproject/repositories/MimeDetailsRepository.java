package com.kp.mime.mimeproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.MimeDetails;

public interface MimeDetailsRepository extends JpaRepository<MimeDetails, Integer>{
    
}

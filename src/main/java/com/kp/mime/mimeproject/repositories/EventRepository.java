package com.kp.mime.mimeproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Event;


public interface EventRepository extends JpaRepository<Event, Integer>{
    List<Event> findByIdIn(List<Integer> idList);
}

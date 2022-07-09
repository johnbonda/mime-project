package com.kp.mime.mimeproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kp.mime.mimeproject.models.entities.Issue;

public interface IssueRepository extends JpaRepository<Issue, Integer>{
    List<Issue> findByIdIn(List<Integer> idList);
}

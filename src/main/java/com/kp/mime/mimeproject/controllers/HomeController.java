package com.kp.mime.mimeproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kp.mime.mimeproject.models.entities.Event;
import com.kp.mime.mimeproject.models.entities.Issue;
import com.kp.mime.mimeproject.models.entities.Organization;
import com.kp.mime.mimeproject.models.entities.Role;
import com.kp.mime.mimeproject.repositories.EventRepository;
import com.kp.mime.mimeproject.repositories.IssueRepository;
import com.kp.mime.mimeproject.repositories.OrganizationRepository;
import com.kp.mime.mimeproject.repositories.RoleRepository;

@RestController
@RequestMapping("api")
@CrossOrigin
public class HomeController {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private IssueRepository issueRepository;
    
    @GetMapping
    public String helloWorld() {
        return "Hello, world";
    }

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/orgs")
    public List<Organization> getOrgs() {
        return organizationRepository.findAll();
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return issueRepository.findAll();
    }

}

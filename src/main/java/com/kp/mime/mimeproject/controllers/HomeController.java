package com.kp.mime.mimeproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kp.mime.mimeproject.MimeService;
import com.kp.mime.mimeproject.models.MimeDTO;
import com.kp.mime.mimeproject.models.entities.Event;
import com.kp.mime.mimeproject.models.entities.Issue;
import com.kp.mime.mimeproject.models.entities.Mime;
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
    RoleRepository roleRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    MimeService mimeService;
    
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

    @PostMapping("/mime")
    public void saveData(@RequestBody MimeDTO mimeDTO) {
        mimeService.saveMime(mimeDTO);        
    }

    @GetMapping("/mime")
    public Mime getMime(@RequestParam(required = true) String lastName) {
        return mimeService.getMime(lastName);
    }

    @GetMapping("/getrolesid")
    public List<Role> getRolesByIds(@RequestBody List<Integer> roles) {
        return roleRepository.findByIdIn(roles);
    }

}

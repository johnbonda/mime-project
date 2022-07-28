package com.kp.mime.mimeproject.models.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class MimeDetails {

    @Id
    private int id;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Mime mime;

    private LocalDateTime dob;
    private boolean member;
    private LocalDateTime joinDate;
    private LocalDateTime leaveDate;

    @ElementCollection
    @CollectionTable
    private List<String> infoWanted;

    private String communicate;
    
    @ElementCollection
    @CollectionTable
    private List<String> traineeLevels;

    @ElementCollection
    @CollectionTable
    private List<String> associations;

    @ManyToMany
    private List<Role> roles;

    @ManyToMany
    private List<Organization> orgs;

    @ManyToMany
    private List<Event> events;

    @ManyToMany
    private List<Issue> issues;

    @ElementCollection
    @CollectionTable
    private List<String> benefits;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mime getMime() {
        return mime;
    }

    public void setMime(Mime mime) {
        this.mime = mime;
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDateTime join) {
        this.joinDate = join;
    }

    public LocalDateTime getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDateTime leave) {
        this.leaveDate = leave;
    }

    public List<String> getInfoWanted() {
        return infoWanted;
    }

    public void setInfoWanted(List<String> infoWanted) {
        this.infoWanted = infoWanted;
    }

    public String getCommunicate() {
        return communicate;
    }

    public void setCommunicate(String communicate) {
        this.communicate = communicate;
    }

    public List<String> getTraineeLevels() {
        return traineeLevels;
    }

    public void setTraineeLevels(List<String> traineeLevels) {
        this.traineeLevels = traineeLevels;
    }

    public List<String> getAssociations() {
        return associations;
    }

    public void setAssociations(List<String> associations) {
        this.associations = associations;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Organization> getOrgs() {
        return orgs;
    }

    public void setOrgs(List<Organization> orgs) {
        this.orgs = orgs;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    
}

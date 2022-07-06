package com.kp.mime.mimeproject.models.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.kp.mime.mimeproject.models.CommunicateType;
import com.kp.mime.mimeproject.models.Status;

@Entity
public class MimeDetails {

    @Id
    private int id;

    @OneToOne
    @MapsId
    private Mime mime;

    private boolean member;
    private LocalDateTime joinDate;
    private LocalDateTime leaveDate;

    @ElementCollection
    @CollectionTable
    private Set<String> infosWanted;

    @Enumerated(EnumType.STRING)
    private CommunicateType communicateType;
    
    @ElementCollection
    @CollectionTable
    private Set<String> traineeLevels;

    @ElementCollection
    @CollectionTable
    private Set<String> associations;

    @OneToMany
    private Set<Role> roles;

    @OneToMany
    private Set<Organization> organizations;

    @OneToMany
    private Set<Event> events;

    @OneToMany
    private Set<Issue> issues;

    private boolean tflOrganizer;

    private LocalDateTime contractDate;
    private LocalDateTime tflDate;
    private String tflFocus;
    private String tflFee;
    private boolean counsellor;
    private String facilitator;
    private String accomodation;

    @Enumerated(EnumType.STRING)
    private Status status;

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

    public void setJoinDate(LocalDateTime joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDateTime getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDateTime leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Set<String> getInfosWanted() {
        return infosWanted;
    }

    public void setInfosWanted(Set<String> infosWanted) {
        this.infosWanted = infosWanted;
    }

    public CommunicateType getCommunicateType() {
        return communicateType;
    }

    public void setCommunicateType(CommunicateType communicateType) {
        this.communicateType = communicateType;
    }

    public Set<String> getTraineeLevels() {
        return traineeLevels;
    }

    public void setTraineeLevels(Set<String> traineeLevels) {
        this.traineeLevels = traineeLevels;
    }

    public Set<String> getAssociations() {
        return associations;
    }

    public void setAssociations(Set<String> associations) {
        this.associations = associations;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Issue> getIssues() {
        return issues;
    }

    public void setIssues(Set<Issue> issues) {
        this.issues = issues;
    }

    public boolean isTflOrganizer() {
        return tflOrganizer;
    }

    public void setTflOrganizer(boolean tflOrganizer) {
        this.tflOrganizer = tflOrganizer;
    }

    public LocalDateTime getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDateTime contractDate) {
        this.contractDate = contractDate;
    }

    public LocalDateTime getTflDate() {
        return tflDate;
    }

    public void setTflDate(LocalDateTime tflDate) {
        this.tflDate = tflDate;
    }

    public String getTflFocus() {
        return tflFocus;
    }

    public void setTflFocus(String tflFocus) {
        this.tflFocus = tflFocus;
    }

    public String getTflFee() {
        return tflFee;
    }

    public void setTflFee(String tflFee) {
        this.tflFee = tflFee;
    }

    public boolean isCounsellor() {
        return counsellor;
    }

    public void setCounsellor(boolean counsellor) {
        this.counsellor = counsellor;
    }

    public String getFacilitator() {
        return facilitator;
    }

    public void setFacilitator(String facilitator) {
        this.facilitator = facilitator;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    
}

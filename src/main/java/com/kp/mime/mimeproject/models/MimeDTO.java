package com.kp.mime.mimeproject.models;

import java.time.LocalDateTime;
import java.util.List;

public class MimeDTO {

    private String firstName;    
    private String lastName;    
    private String jobTitle;    
    private String company;    
    private String address;    
    private String city;    
    private String province;    
    private int postalCode;    
    private String country;    
    private String area;    
    private PhoneDTO phone;
    private String email;    
    private String url;    
    private String notes;    
    private LocalDateTime dob;    
    private boolean member;
    private LocalDateTime join;    
    private LocalDateTime leave;    
    private List<String> infoWanted;
    private String communicate;    
    private List<String> traineeLevels;
    private List<String> associations;
    private List<Integer> roles;
    private List<Integer> orgs;
    private List<Integer> events;
    private List<Integer> issues;
    private List<String> benefits;
    private String status;

    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public PhoneDTO getPhone() {
        return phone;
    }
    public void setPhone(PhoneDTO phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public boolean isMember() {
        return member;
    }
    public void setMember(boolean member) {
        this.member = member;
    }
    public LocalDateTime getJoin() {
        return join;
    }
    public void setJoin(LocalDateTime join) {
        this.join = join;
    }
    public LocalDateTime getLeave() {
        return leave;
    }
    public void setLeave(LocalDateTime leave) {
        this.leave = leave;
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
    public List<Integer> getRoles() {
        return roles;
    }
    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
    public List<Integer> getOrgs() {
        return orgs;
    }
    public void setOrgs(List<Integer> orgs) {
        this.orgs = orgs;
    }
    public List<Integer> getEvents() {
        return events;
    }
    public void setEvents(List<Integer> events) {
        this.events = events;
    }
    public List<Integer> getIssues() {
        return issues;
    }
    public void setIssues(List<Integer> issues) {
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

package com.kp.mime.mimeproject.models.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mime {
    
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "mime", cascade = CascadeType.ALL)
    private MimeDetails mimeDetails;

    private String firstName;

    @Column(unique = true)
    private String lastName;
    private String jobTitle;
    private String company;
    private String address;
    private String city;
    private String province;
    private int postalCode;
    private String country;
    private String area;
    private String phone;
    private String phoneType;
    private String email;
    private String url;
    private String notes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public MimeDetails getMimeDetails() {
        return mimeDetails;
    }
    public void setMimeDetails(MimeDetails mimeDetails) {
        this.mimeDetails = mimeDetails;
    }
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhoneType() {
        return phoneType;
    }
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
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

    
}

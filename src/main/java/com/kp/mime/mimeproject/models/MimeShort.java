package com.kp.mime.mimeproject.models;

public class MimeShort {
    private int id;
    private String lastName;

    public MimeShort() {}

    public MimeShort(int id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

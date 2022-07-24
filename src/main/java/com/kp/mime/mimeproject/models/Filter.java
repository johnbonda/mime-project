package com.kp.mime.mimeproject.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Filter {

    private Map<String, String> queries = new HashMap<>();
    private List<Integer> roles = new ArrayList<>();

    public Map<String, String> getQueries() {
        return queries;
    }
    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }
    public List<Integer> getRoles() {
        return roles;
    }
    public void setRoles(List<Integer> roles) {
        this.roles = roles;
    }
    
}

package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class AuthResponse {
    private String token;
    private List<Role> roles = new ArrayList<Role>();

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

}
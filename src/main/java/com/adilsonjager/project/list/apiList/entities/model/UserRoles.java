package com.adilsonjager.project.list.apiList.entities.model;

import java.io.Serializable;


public enum UserRoles implements Serializable {
    ADMIN("admin"),
    PUBLIC("user");

    private String role;

    UserRoles(String role){ this.role = role;}

    public String getRole(){return role;}

}

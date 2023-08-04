package com.adilsonjager.project.list.apiList.entities.response;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Entity;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class LocationResponse {

    private String id;
    private String name;
    private String type;
    private List<String> residents;
    private String url;

    public String getName(){
        return name;
    }

}

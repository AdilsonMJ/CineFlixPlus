package com.adilsonjager.project.list.apiList.Services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Object: " + id);
    }

}

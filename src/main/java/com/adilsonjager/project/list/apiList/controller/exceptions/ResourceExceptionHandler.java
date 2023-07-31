package com.adilsonjager.project.list.apiList.controller.exceptions;

import com.adilsonjager.project.list.apiList.Services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandError> resourceNotFind(ResourceNotFoundException e, HttpServletRequest request){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandError err = new StandError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}

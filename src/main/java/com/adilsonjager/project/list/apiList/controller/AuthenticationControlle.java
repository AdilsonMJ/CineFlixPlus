package com.adilsonjager.project.list.apiList.controller;

import com.adilsonjager.project.list.apiList.Services.authAndRegister.RegisterUserService;
import com.adilsonjager.project.list.apiList.entities.DTO.AuthenticationDTO;
import com.adilsonjager.project.list.apiList.entities.DTO.LoginResponseDTO;
import com.adilsonjager.project.list.apiList.entities.DTO.RegisterDTO;
import com.adilsonjager.project.list.apiList.entities.model.UserModel;
import com.adilsonjager.project.list.apiList.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/auth")
public class AuthenticationControlle {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RegisterUserService userService;

    @Autowired
    TokenService tokenService;


    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {

        var userNamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        return ResponseEntity.status(userService.createdUserAndAPI(data)).build();
    }

}



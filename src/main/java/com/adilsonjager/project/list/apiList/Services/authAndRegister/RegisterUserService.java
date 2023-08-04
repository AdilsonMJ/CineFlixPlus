package com.adilsonjager.project.list.apiList.Services.authAndRegister;

import com.adilsonjager.project.list.apiList.entities.DTO.RegisterDTO;
import com.adilsonjager.project.list.apiList.entities.model.UserModel;
import com.adilsonjager.project.list.apiList.entities.model.UserRoles;
import com.adilsonjager.project.list.apiList.repository.localDB.RepositoryUserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    @Autowired
    private RepositoryUserDB repositoryUserDB;

    public HttpStatus createdUserAndAPI(RegisterDTO data) {

        if (repositoryUserDB.findByEmail(data.login()) != null) return HttpStatus.BAD_REQUEST;

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        UserModel userModel = new UserModel(data.login(), encryptedPassword, UserRoles.PUBLIC);


        repositoryUserDB.save(userModel);
        return HttpStatus.CREATED;


    }


}

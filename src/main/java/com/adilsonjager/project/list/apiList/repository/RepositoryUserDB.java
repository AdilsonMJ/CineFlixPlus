package com.adilsonjager.project.list.apiList.repository;


import com.adilsonjager.project.list.apiList.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositoryUserDB extends JpaRepository<UserModel, String> {

    UserDetails findByEmail(String email);

}

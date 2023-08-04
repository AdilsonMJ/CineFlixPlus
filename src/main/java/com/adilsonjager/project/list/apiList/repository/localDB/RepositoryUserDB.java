package com.adilsonjager.project.list.apiList.repository.localDB;


import com.adilsonjager.project.list.apiList.entities.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUserDB extends JpaRepository<UserModel, String> {

    UserDetails findByEmail(String email);

}

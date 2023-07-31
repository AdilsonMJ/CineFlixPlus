package com.adilsonjager.project.list.apiList.Services;

import com.adilsonjager.project.list.apiList.repository.RepositoryUserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    RepositoryUserDB repositoryUserDB;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repositoryUserDB.findByEmail(username);
    }
}

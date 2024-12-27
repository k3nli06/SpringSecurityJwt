package com.k3nli.pruebaspringsecurityjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.k3nli.pruebaspringsecurityjwt.persistence.entities.UserEntity;
import com.k3nli.pruebaspringsecurityjwt.persistence.repository.iUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    iUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        return new User(user.getUsername(),
            user.getPassword(),
            user.getAuthorities());
    }

}

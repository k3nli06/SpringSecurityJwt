package com.k3nli.pruebaspringsecurityjwt.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.k3nli.pruebaspringsecurityjwt.DTO.*;
import com.k3nli.pruebaspringsecurityjwt.persistence.entities.*;
import com.k3nli.pruebaspringsecurityjwt.persistence.repository.iUserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
    private iUserRepository repository;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticacionManager;
    
    public AuthenticationResponseDto login (LoginDto login) {
        authenticacionManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
        UserEntity user = repository.findByUsername(login.getUsername()).get();

        return AuthenticationResponseDto.builder()
            .token(jwtService.getToken(user))
            .build();
    }

    public AuthenticationResponseDto register (RegisterDto register) {
        UserEntity user = (UserEntity.builder()
            .email(register.getEmail())
            .username(register.getUsername())
            .password(passwordEncoder.encode(register.getPassword()))
            .role(RoleEnum.USER)
            .build());
        repository.save(user);

        return AuthenticationResponseDto.builder()
            .token(jwtService.getToken(user))
            .build();        
    }

}

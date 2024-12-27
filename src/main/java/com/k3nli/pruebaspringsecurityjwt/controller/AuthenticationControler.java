package com.k3nli.pruebaspringsecurityjwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k3nli.pruebaspringsecurityjwt.DTO.*;
import com.k3nli.pruebaspringsecurityjwt.service.AuthenticationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("authentication/")
@PreAuthorize("permitAll()")
public class AuthenticationControler {
    @Autowired
    AuthenticationService authenticationService;
    
    @PostMapping("login")
    public ResponseEntity<AuthenticationResponseDto> login (@RequestBody LoginDto loginDto) {   
        return ResponseEntity.ok(authenticationService.login(loginDto));
    }
    
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterDto registerDto) {
        return ResponseEntity.ok(authenticationService.register(registerDto));    
    }
}

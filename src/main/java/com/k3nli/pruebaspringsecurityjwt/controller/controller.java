package com.k3nli.pruebaspringsecurityjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("api/v1/")
public class controller {
    @GetMapping("not_secure")
    @PreAuthorize("permitAll()")
    public String notSecure () {
        return "hello world";
    }
    
    @GetMapping("secure")
    @PreAuthorize("hasRole('ADMIN')")
    public String secure () {
        return "hello secure world";
    }
}

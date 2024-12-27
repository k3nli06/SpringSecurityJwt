package com.k3nli.pruebaspringsecurityjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

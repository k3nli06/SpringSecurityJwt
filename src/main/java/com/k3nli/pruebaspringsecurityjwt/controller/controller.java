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
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String secure () {
        return "hello secure world";
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGenericException (Exception exception, HttpServletRequest request) {
        Map<String, Object> apiError = new HashMap<>();
        apiError.put("message", exception.getLocalizedMessage());
        apiError.put("timestamp", new Date().toString());
        apiError.put("url", request.getRequestURL().toString());
        apiError.put("http-metod", request.getMethod());

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        if (exception instanceof AccessDeniedException) {
            status = HttpStatus.FORBIDDEN;
        }
        return ResponseEntity.status(status).body(apiError);
    }
}

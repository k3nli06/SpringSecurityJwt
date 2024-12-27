package com.k3nli.pruebaspringsecurityjwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.k3nli.pruebaspringsecurityjwt.persistence.entities.UserEntity;
import com.k3nli.pruebaspringsecurityjwt.service.UserService;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    
    @GetMapping("/get_users")
    public Collection<UserEntity> getUsers () {
        return userService.getAllUsers();
    }
    
}

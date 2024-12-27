package com.k3nli.pruebaspringsecurityjwt.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.k3nli.pruebaspringsecurityjwt.persistence.entities.UserEntity;
import com.k3nli.pruebaspringsecurityjwt.persistence.repository.iUserRepository;

@Service
public class UserService {
    @Autowired
    iUserRepository repository;

    public Collection<UserEntity> getAllUsers() {
        return repository.findAll();
    }

    public Optional<UserEntity> findUser (long id) {
        return repository.findById(id);
    }

    public void saveUser (UserEntity user) {
        repository.save(user);
    }

    public String deleteUser (long id) {
        UserEntity user = repository.findById(id).orElseThrow(
            () -> new UsernameNotFoundException("El usuario no existe"));
        repository.delete(user);
        return "eliminado con exito";
    }
}

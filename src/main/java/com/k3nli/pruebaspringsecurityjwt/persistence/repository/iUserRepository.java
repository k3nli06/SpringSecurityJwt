package com.k3nli.pruebaspringsecurityjwt.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.k3nli.pruebaspringsecurityjwt.persistence.entities.UserEntity;

@Repository
public interface iUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername (String username);
}

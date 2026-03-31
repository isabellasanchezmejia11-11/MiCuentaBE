package com.fabricaescuela.micuenta.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricaescuela.micuenta.infraestructure.persistence.entity.UserEntity;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
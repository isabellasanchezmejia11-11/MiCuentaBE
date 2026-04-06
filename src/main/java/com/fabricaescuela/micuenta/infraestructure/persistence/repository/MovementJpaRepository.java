package com.fabricaescuela.micuenta.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabricaescuela.micuenta.infraestructure.persistence.entity.MovementEntity;

public interface MovementJpaRepository extends JpaRepository<MovementEntity, Long> {

}

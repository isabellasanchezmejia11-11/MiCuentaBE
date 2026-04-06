package com.fabricaescuela.micuenta.domain.repository;

import com.fabricaescuela.micuenta.domain.model.Movement;

public interface MovementRepository {

    Movement save(Movement movement);
}

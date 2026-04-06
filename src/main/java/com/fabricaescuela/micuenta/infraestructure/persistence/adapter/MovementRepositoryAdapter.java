package com.fabricaescuela.micuenta.infraestructure.persistence.adapter;

import org.springframework.stereotype.Repository;
import com.fabricaescuela.micuenta.domain.model.Movement;
import com.fabricaescuela.micuenta.domain.repository.MovementRepository;
import com.fabricaescuela.micuenta.infraestructure.persistence.entity.MovementEntity;
import com.fabricaescuela.micuenta.infraestructure.persistence.repository.MovementJpaRepository;

@Repository
public class MovementRepositoryAdapter implements MovementRepository {

    private final MovementJpaRepository jpaRepository;

    public MovementRepositoryAdapter(MovementJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Movement save(Movement movement) {

        MovementEntity entity = new MovementEntity(
                movement.getId(),
                movement.getAmount(),
                movement.getDate(),
                movement.getType(),
                movement.getCategoryId(),
                movement.getDescription(),
                movement.getUserId()
        );

        MovementEntity saved = jpaRepository.save(entity);

        return new Movement(
                saved.getId(),
                saved.getAmount(),
                saved.getDate(),
                saved.getDescription(),
                saved.getCategoryId(),
                saved.getUserId(),
                saved.getType()
        );
    }
}

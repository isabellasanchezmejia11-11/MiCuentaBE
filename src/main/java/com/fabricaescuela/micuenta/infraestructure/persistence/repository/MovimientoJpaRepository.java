package com.fabricaescuela.micuenta.infraestructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fabricaescuela.micuenta.infraestructure.persistence.entity.MovimientoEntity;

@Repository 
public interface MovimientoJpaRepository extends JpaRepository<MovimientoEntity, Long> {

    @Query("SELECT m FROM MovimientoEntity m WHERE m.usuarioId = :usuarioId AND MONTH(m.fecha) = :mes AND YEAR(m.fecha) = :anio")
    List<MovimientoEntity> buscarPorUsuarioYMes(
        @Param("usuarioId") Long usuarioId,
        @Param("mes") int mes,
        @Param("anio") int anio
    );
} 

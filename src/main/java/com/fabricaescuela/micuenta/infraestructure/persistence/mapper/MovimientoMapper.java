package com.fabricaescuela.micuenta.infraestructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.fabricaescuela.micuenta.domain.model.Movimiento;
import com.fabricaescuela.micuenta.infraestructure.persistence.entity.MovimientoEntity;

@Component
public class MovimientoMapper {
    public Movimiento toDomain(MovimientoEntity entity){
        if (entity == null) {
            return null;
        }
        Movimiento movimiento = new Movimiento();
        movimiento.setId(entity.getId());
        movimiento.setUsuarioId(entity.getUsuarioId());
        movimiento.setMonto(entity.getMonto());
        movimiento.setTipo(entity.getTipo());
        movimiento.setFecha(entity.getFecha());
        movimiento.setDescripcion(entity.getDescripcion());
        return movimiento;
    }

    public MovimientoEntity toEntity(Movimiento domain) {
        if (domain == null) return null;

        MovimientoEntity entity = new MovimientoEntity();
        entity.setUsuarioId(domain.getUsuarioId());
        entity.setMonto(domain.getMonto());
        entity.setTipo(domain.getTipo());
        entity.setFecha(domain.getFecha());
        entity.setCategoria(domain.getCategoria()); 
        entity.setDescripcion(domain.getDescripcion());
        return entity;
    }
}

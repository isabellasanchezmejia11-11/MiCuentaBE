package com.fabricaescuela.micuenta.infraestructure.persistence.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fabricaescuela.micuenta.domain.model.Movimiento;
import com.fabricaescuela.micuenta.domain.repository.MovimientoRepository;
import com.fabricaescuela.micuenta.infraestructure.persistence.entity.MovimientoEntity;
import com.fabricaescuela.micuenta.infraestructure.persistence.mapper.MovimientoMapper;
import com.fabricaescuela.micuenta.infraestructure.persistence.repository.MovimientoJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MovimientoRepositoryAdapter implements MovimientoRepository {

    private final MovimientoJpaRepository jpaRepository;
    private final MovimientoMapper mapper;

    @Override
    public void save(Movimiento movimiento) {
        MovimientoEntity entidad = mapper.toEntity(movimiento);

        jpaRepository.save(entidad);
    }

    @Override
    public List<Movimiento> obtenerPorUsuarioYMes(Long usuarioId, int mes, int anio){
        List<MovimientoEntity> entidades = jpaRepository.buscarPorUsuarioYMes(usuarioId, mes, anio);
        return entidades.stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

}

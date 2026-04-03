package com.fabricaescuela.micuenta.domain.repository;

import java.util.List;

import com.fabricaescuela.micuenta.domain.model.Movimiento;

public interface MovimientoRepository {

    void save(Movimiento movimiento);

    List<Movimiento> obtenerPorUsuarioYMes(Long usuarioId, int mes, int anio);
    
} 
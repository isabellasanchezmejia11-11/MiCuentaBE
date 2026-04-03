package com.fabricaescuela.micuenta.application.usecase;

import org.springframework.stereotype.Service;
import com.fabricaescuela.micuenta.application.dto.request.CreateMovimientoRequest;
import com.fabricaescuela.micuenta.domain.model.Movimiento; 
import com.fabricaescuela.micuenta.domain.model.enums.TipoMovimiento;
import com.fabricaescuela.micuenta.domain.repository.MovimientoRepository;

@Service
public class RegistrarIngresoUseCase {
    
    private final MovimientoRepository movimientoRepository;

    public RegistrarIngresoUseCase(MovimientoRepository movimientoRepository) {
        this.movimientoRepository = movimientoRepository;
    }

    public void ejecutar(CreateMovimientoRequest request, Long usuarioId) {

        if (request.getTipo() != TipoMovimiento.INGRESO) {
            throw new IllegalArgumentException("Este servicio solo registra ingresos");
        }

        if (request.getCategoria().getTipoAsociado() != TipoMovimiento.INGRESO) {
            throw new IllegalArgumentException("La categoría " + request.getCategoria() + " no es válida para un ingreso");
        }

        Movimiento nuevoIngreso = new Movimiento(); 
        
        nuevoIngreso.setTipo(request.getTipo());
        nuevoIngreso.setCategoria(request.getCategoria());
        nuevoIngreso.setMonto(request.getMonto());
        nuevoIngreso.setFecha(request.getFecha());
        nuevoIngreso.setDescripcion(request.getDescripcion());
        nuevoIngreso.setUsuarioId(usuarioId);

        movimientoRepository.save(nuevoIngreso); 
    }
}
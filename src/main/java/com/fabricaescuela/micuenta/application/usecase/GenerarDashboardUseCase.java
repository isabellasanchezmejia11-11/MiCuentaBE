package com.fabricaescuela.micuenta.application.usecase;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fabricaescuela.micuenta.application.dto.response.DashboardResponse;
import com.fabricaescuela.micuenta.domain.model.Movimiento;
import com.fabricaescuela.micuenta.domain.model.enums.TipoMovimiento;
import com.fabricaescuela.micuenta.domain.repository.MovimientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenerarDashboardUseCase {

    private final MovimientoRepository movimientoRepository;

    public DashboardResponse ejecutar(Long usuarioId){
        LocalDate hoy = LocalDate.now();

        List<Movimiento> movimientosDelMes = movimientoRepository.obtenerPorUsuarioYMes(usuarioId, hoy.getMonthValue(), hoy.getYear());

        if (movimientosDelMes.isEmpty()){
            return new DashboardResponse(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, List.of(), "Aun no tienes movimientos este mes. ¡Empieza a registrando uno!");
            
        }

        BigDecimal ingresos = calcularTotalPorTipo(movimientosDelMes, TipoMovimiento.INGRESO);
        BigDecimal gastos = calcularTotalPorTipo(movimientosDelMes, TipoMovimiento.GASTO);
        BigDecimal balance = ingresos.subtract(gastos);

        return new DashboardResponse(ingresos, gastos, balance, movimientosDelMes, "    Dashboard cargado");
    }

    private BigDecimal calcularTotalPorTipo(List<Movimiento> movimientos, TipoMovimiento tipo) {
        return movimientos.stream()
                .filter(m -> m.getTipo() == tipo)
                .map(Movimiento::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    

}

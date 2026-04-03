package com.fabricaescuela.micuenta.application.dto.response;

import java.math.BigDecimal;
import java.util.List;

import com.fabricaescuela.micuenta.domain.model.Movimiento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {
    private BigDecimal totalIngresos;
    private BigDecimal totalGastos;
    private BigDecimal balanceNeto;
    private List<Movimiento> ultimosMovimientos;
    private String mensaje;

    
}

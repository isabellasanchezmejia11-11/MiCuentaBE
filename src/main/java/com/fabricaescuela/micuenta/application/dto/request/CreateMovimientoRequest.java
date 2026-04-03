package com.fabricaescuela.micuenta.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import com.fabricaescuela.micuenta.domain.model.enums.CategoriaMovimiento;
import com.fabricaescuela.micuenta.domain.model.enums.TipoMovimiento;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMovimientoRequest {
    @NotNull(message = "El tipo de movimiento es obligatorio")
    private TipoMovimiento tipo; 
    
    @Positive(message = "El monto debe ser mayor a 0")
    private BigDecimal monto;
    
    @NotNull(message = "La fecha es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    private LocalDate fecha;
    
    @NotNull(message = "La categoría es obligatoria") 
    private CategoriaMovimiento categoria; 
    
    private String descripcion;
}
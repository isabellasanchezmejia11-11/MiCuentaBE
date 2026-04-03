package com.fabricaescuela.micuenta.infraestructure.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fabricaescuela.micuenta.domain.model.enums.CategoriaMovimiento;
import com.fabricaescuela.micuenta.domain.model.enums.TipoMovimiento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimientos")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING) 
    @Column(nullable = false)
    private TipoMovimiento tipo; 

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoriaMovimiento categoria;
}



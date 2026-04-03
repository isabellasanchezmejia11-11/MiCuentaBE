package com.fabricaescuela.micuenta.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fabricaescuela.micuenta.domain.model.enums.CategoriaMovimiento;
import com.fabricaescuela.micuenta.domain.model.enums.TipoMovimiento;

public class Movimiento {

    private Long id;
    private Long usuarioId;
    
    private BigDecimal monto;
    private LocalDate fecha;
    private TipoMovimiento tipo;
    private CategoriaMovimiento categoria;
    private String descripcion;

    public Movimiento() {
    }

    public Movimiento(BigDecimal monto, LocalDate fecha, TipoMovimiento tipo, CategoriaMovimiento categoria, String descripcion) {
        this.monto = monto;
        this.fecha = fecha;
        this.tipo = tipo;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public TipoMovimiento getTipo() { return tipo; }
    public void setTipo(TipoMovimiento tipo) { this.tipo = tipo; }
    public CategoriaMovimiento getCategoria() { return categoria; }
    public void setCategoria(CategoriaMovimiento categoria) { this.categoria = categoria; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
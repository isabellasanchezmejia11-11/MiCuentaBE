package com.fabricaescuela.micuenta.domain.model.enums;

public enum CategoriaMovimiento {
    
    // --- CATEGORÍAS DE INGRESO ---
    SALARIO(TipoMovimiento.INGRESO),
    HONORARIOS(TipoMovimiento.INGRESO),
    VENTAS(TipoMovimiento.INGRESO),
    OTROS_INGRESOS(TipoMovimiento.INGRESO),

    // --- CATEGORÍAS DE GASTO ---
    ALIMENTACION(TipoMovimiento.GASTO),
    TRANSPORTE(TipoMovimiento.GASTO),
    SERVICIOS(TipoMovimiento.GASTO),
    ENTRETENIMIENTO(TipoMovimiento.GASTO),
    OTROS_GASTOS(TipoMovimiento.GASTO);

    // 1. Le agregamos una propiedad interna
    private final TipoMovimiento tipoAsociado;

    // 2. Creamos su constructor
    CategoriaMovimiento(TipoMovimiento tipoAsociado) {
        this.tipoAsociado = tipoAsociado;
    }

    // 3. Método para consultar su tipo
    public TipoMovimiento getTipoAsociado() {
        return tipoAsociado;
    }
}
package com.fabricaescuela.micuenta.interfaces.rest;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaescuela.micuenta.application.dto.request.CreateMovimientoRequest;
import com.fabricaescuela.micuenta.application.usecase.RegistrarIngresoUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ingresos")
public class IngresoController {

    private final RegistrarIngresoUseCase registrarIngresoUseCase;

    public IngresoController(RegistrarIngresoUseCase registrarIngresoUseCase) {
        this.registrarIngresoUseCase = registrarIngresoUseCase;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> registrar(
        @Valid @RequestBody CreateMovimientoRequest request,
        Authentication authentication
    ) {
        //String email = authentication.getName();
        Long usuarioIdReal = 1L;
        registrarIngresoUseCase.ejecutar(request, usuarioIdReal);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Movimiento creado exitosamente"));
    }

}

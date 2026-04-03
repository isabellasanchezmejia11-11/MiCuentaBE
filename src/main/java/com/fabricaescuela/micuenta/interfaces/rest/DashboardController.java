package com.fabricaescuela.micuenta.interfaces.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaescuela.micuenta.application.dto.response.DashboardResponse;
import com.fabricaescuela.micuenta.application.usecase.GenerarDashboardUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final GenerarDashboardUseCase generarDashboardUseCase;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<DashboardResponse> obtenerDashboard(@PathVariable Long usuarioId) {
        DashboardResponse response = generarDashboardUseCase.ejecutar(usuarioId);
        return ResponseEntity.ok(response);
    }
}

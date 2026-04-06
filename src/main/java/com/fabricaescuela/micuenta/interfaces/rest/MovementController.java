package com.fabricaescuela.micuenta.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaescuela.micuenta.application.dto.request.RegisterExpenseRequest;
import com.fabricaescuela.micuenta.application.usecase.RegisterExpenseUseCase;
import com.fabricaescuela.micuenta.domain.model.Movement;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/movements")
public class MovementController {

    private final RegisterExpenseUseCase useCase;

    public MovementController(RegisterExpenseUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/expense")
    public ResponseEntity<Movement> registerExpense(
            @RequestBody RegisterExpenseRequest request,
            @AuthenticationPrincipal String userEmail) {

        Movement saved = useCase.execute(request, userEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}

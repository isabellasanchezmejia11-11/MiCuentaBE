package com.fabricaescuela.micuenta.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaescuela.micuenta.application.dto.request.CreateMovementRequest;
import com.fabricaescuela.micuenta.application.dto.response.MovementResponse;
import com.fabricaescuela.micuenta.application.usecase.ListExpensesUseCase;
import com.fabricaescuela.micuenta.application.usecase.ListIncomesUseCase;
import com.fabricaescuela.micuenta.application.usecase.RegisterExpenseUseCase;
import com.fabricaescuela.micuenta.application.usecase.RegisterIncomeUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movements")
public class MovementController {

    private final RegisterIncomeUseCase registerIncomeUseCase;
    private final RegisterExpenseUseCase registerExpenseUseCase;
    private final ListIncomesUseCase listIncomesUseCase;
    private final ListExpensesUseCase listExpensesUseCase;

    public MovementController(
            RegisterIncomeUseCase registerIncomeUseCase,
            RegisterExpenseUseCase registerExpenseUseCase,
            ListIncomesUseCase listIncomesUseCase,
            ListExpensesUseCase listExpensesUseCase
    ) {
        this.registerIncomeUseCase = registerIncomeUseCase;
        this.registerExpenseUseCase = registerExpenseUseCase;
        this.listIncomesUseCase = listIncomesUseCase;
        this.listExpensesUseCase = listExpensesUseCase;
    }

    @PostMapping("/incomes")
    public ResponseEntity<MovementResponse> registerIncome(
            @Valid @RequestBody CreateMovementRequest request,
            Authentication authentication
    ) {
        String email = (String) authentication.getPrincipal();
        MovementResponse response = registerIncomeUseCase.execute(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/expenses")
    public ResponseEntity<MovementResponse> registerExpense(
            @Valid @RequestBody CreateMovementRequest request,
            Authentication authentication
    ) {
        String email = (String) authentication.getPrincipal();
        MovementResponse response = registerExpenseUseCase.execute(email, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/incomes")
    public ResponseEntity<List<MovementResponse>> listIncomes(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        return ResponseEntity.ok(listIncomesUseCase.execute(email));
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<MovementResponse>> listExpenses(Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        return ResponseEntity.ok(listExpensesUseCase.execute(email));
    }
}
package com.fabricaescuela.micuenta.application.usecase;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fabricaescuela.micuenta.application.dto.request.RegisterExpenseRequest;
import com.fabricaescuela.micuenta.application.exception.ResourceNotFoundException;
import com.fabricaescuela.micuenta.domain.model.Movement;
import com.fabricaescuela.micuenta.domain.model.MovementType;
import com.fabricaescuela.micuenta.domain.repository.MovementRepository;
import com.fabricaescuela.micuenta.domain.repository.UserRepository;

@Service // ← Sin esto Spring no lo inyecta y la app no arranca
public class RegisterExpenseUseCase {

    private final MovementRepository movementRepository;
    private final UserRepository userRepository;

    public RegisterExpenseUseCase(MovementRepository movementRepository,
            UserRepository userRepository) {
        this.movementRepository = movementRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Movement execute(RegisterExpenseRequest request, String userEmail) {

        Long userId = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException(
                "Usuario no encontrado"))
                .id();

        if (request.getAmount() == null
                || request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe ser mayor a 0");
        }

        if (request.getDate() == null
                || request.getDate().isAfter(LocalDate.now())) {
            throw new RuntimeException("La fecha no puede ser futura");
        }

  
        if (request.getCategoryId() == null) {
            throw new RuntimeException("La categoría es obligatoria");
        }

        Movement movement = new Movement(
                null,
                request.getAmount(),
                request.getDate(),
                request.getDescription(),
                request.getCategoryId(),
                userId,
                MovementType.EXPENSE
        );
        return movementRepository.save(movement);
    }
}

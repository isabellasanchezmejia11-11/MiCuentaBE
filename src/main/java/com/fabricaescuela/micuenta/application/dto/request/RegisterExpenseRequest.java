package com.fabricaescuela.micuenta.application.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegisterExpenseRequest {

    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private Long categoryId;

    public RegisterExpenseRequest() {

    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public Long getCategoryId() {
        return categoryId;
    }
}

package com.fabricaescuela.micuenta.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movement {

    private Long id;
    private BigDecimal amount;
    private LocalDate date;
    private String description;
    private Long categoryId;
    private Long userId;
    private MovementType type;

    public Movement(Long id, BigDecimal amount, LocalDate date, String description, Long categoryId, Long userId, MovementType type) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.description = description;
        this.categoryId = categoryId;
        this.userId = userId;
        this.type = type;
    }

    public Long getId() {
        return id;
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

    public Long getUserId() {
        return userId;
    }

    public MovementType getType() {
        return type;
    }

}

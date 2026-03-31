package com.fabricaescuela.micuenta.domain.model;

public record User(
        Long id,
        String name,
        String email,
        String passwordHash
) {
}
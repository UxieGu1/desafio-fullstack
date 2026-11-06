package br.com.desafiofullstack.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(
        @NotBlank(message = "The name is required")
        String name,

        @NotNull(message = "The price is required")
        @Positive(message = "The price must be greater than zero")
        BigDecimal price,

        @NotNull(message = "The quantity is required")
        @Positive(message = "The quantity must be greater than zero")
        Integer quantity
) {
}

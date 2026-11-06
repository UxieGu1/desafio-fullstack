package br.com.desafiofullstack.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductItemResponse(
        String name,
        BigDecimal price,
        LocalDateTime createdAt
) {
}
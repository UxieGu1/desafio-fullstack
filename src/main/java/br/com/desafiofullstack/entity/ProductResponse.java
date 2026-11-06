package br.com.desafiofullstack.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductResponse(

        Long productId,
        String name,
        BigDecimal price,
        Integer quantity,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}

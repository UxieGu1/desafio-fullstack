package br.com.desafiofullstack.mapper;

import br.com.desafiofullstack.entity.ProductItemResponse;
import br.com.desafiofullstack.entity.ProductRequest;
import br.com.desafiofullstack.entity.ProductResponse;
import br.com.desafiofullstack.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductMapper {


    public ProductResponse toResponse(Product product) {
        if (product == null) {
            return null;
        }
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }

    public Product toEntity(ProductRequest request) {
        if (request == null) {
            return null;
        }

        Product product = new Product();
        product.setName(request.name());
        product.setPrice(request.price());
        product.setQuantity(request.quantity());

        return product;
    }

    public ProductItemResponse toItemResponse(Product product) {
        if (product == null) {
            return null;
        }

        return new ProductItemResponse(
                product.getName(),
                product.getPrice(),
                product.getCreatedAt()
        );
    }

    public void updateEntityFromRequest(ProductRequest request, Product entity) {
        if (request == null || entity == null) {
            return;
        }
        entity.setName(request.name());
        entity.setPrice(request.price());
        entity.setQuantity(request.quantity());
        entity.setUpdatedAt(LocalDateTime.now());
    }
}
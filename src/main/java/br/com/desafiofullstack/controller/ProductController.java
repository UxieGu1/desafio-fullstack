package br.com.desafiofullstack.controller;

import br.com.desafiofullstack.entity.PageResponse;
import br.com.desafiofullstack.entity.ProductItemResponse;
import br.com.desafiofullstack.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<PageResponse<ProductItemResponse>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        PageResponse<ProductItemResponse> response = productService.findAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

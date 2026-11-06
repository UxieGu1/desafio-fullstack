package br.com.desafiofullstack.service;

import br.com.desafiofullstack.entity.PageResponse;
import br.com.desafiofullstack.entity.ProductItemResponse;
import br.com.desafiofullstack.entity.ProductResponse;
import br.com.desafiofullstack.mapper.ProductMapper;
import br.com.desafiofullstack.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private static final int MAX_PAGE_SIZE = 100;
    private static final int DEFAULT_PAGE_SIZE = 10;

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public PageResponse<ProductItemResponse> findAll(int page, int size) {
        int sizeFinal = Math.clamp(size, 1, 100);
        int pageFinal = Math.max(0, page);

        Pageable pageable = PageRequest.of(pageFinal, sizeFinal, Sort.by("productId").ascending());

        Page<ProductItemResponse> productPage = productRepository.findAll(pageable)
                .map(productMapper::toItemResponse);

        return PageResponse.from(productPage);
    }
}

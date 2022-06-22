package com.sofkaU.productmicroservice.usecases;

import com.sofkaU.productmicroservice.dto.ProductDto;
import com.sofkaU.productmicroservice.mapper.ProductMapper;
import com.sofkaU.productmicroservice.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CreateProductUseCase implements Function<ProductDto, Mono<ProductDto>> {

    private final IProductRepository repository;
    private final ProductMapper productMapper;

    @Override
    public Mono<ProductDto> apply(ProductDto productDto) {
        return repository.save(productMapper
                .convertDtoToEntity()
                .apply(productDto))
                .map(productEntity -> productMapper
                        .convertEntityToDto()
                        .apply(productEntity));
    }
}

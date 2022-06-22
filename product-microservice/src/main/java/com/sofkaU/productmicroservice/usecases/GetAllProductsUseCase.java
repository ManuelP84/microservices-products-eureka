package com.sofkaU.productmicroservice.usecases;

import com.sofkaU.productmicroservice.dto.ProductDto;
import com.sofkaU.productmicroservice.mapper.ProductMapper;
import com.sofkaU.productmicroservice.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class GetAllProductsUseCase implements Supplier {

    private final IProductRepository repository;
    private final ProductMapper productMapper;


    @Override
    public Flux<ProductDto> get() {
        System.out.println("Test");
        return repository
                .findAll()
                .map(productEntity -> productMapper
                        .convertEntityToDto()
                        .apply(productEntity));
    }
}

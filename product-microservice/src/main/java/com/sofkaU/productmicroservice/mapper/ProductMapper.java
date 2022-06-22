package com.sofkaU.productmicroservice.mapper;

import com.sofkaU.productmicroservice.dto.ProductDto;
import com.sofkaU.productmicroservice.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public Function<ProductDto, ProductEntity> convertDtoToEntity(){
        return productDto -> modelMapper.map(productDto, ProductEntity.class);
    }

    public Function<ProductEntity, ProductDto> convertEntityToDto(){
        return productEntity -> modelMapper.map(productEntity, ProductDto.class);
    }
}

package com.sofkaU.productmicroservice.dto;

import lombok.Data;

@Data
public class ProductDto {

    private String id;

    private String name;

    private String productDescription;

    private Double unitPrice;
}

package com.sofkaU.productmicroservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
@Setter
@Getter
@NoArgsConstructor
public class ProductEntity {

    @Id
    private String id;

    private String name;

    private String productDescription;

    private Double unitPrice;

}

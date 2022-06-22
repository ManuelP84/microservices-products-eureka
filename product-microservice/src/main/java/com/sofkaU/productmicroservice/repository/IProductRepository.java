package com.sofkaU.productmicroservice.repository;

import com.sofkaU.productmicroservice.entity.ProductEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends ReactiveMongoRepository<ProductEntity, String> {
}

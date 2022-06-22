package com.sofkaU.productmicroservice.routes;

import com.sofkaU.productmicroservice.dto.ProductDto;
import com.sofkaU.productmicroservice.usecases.CreateProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateProductRoute {

    @Bean
    public RouterFunction<ServerResponse> createProducteRouter(CreateProductUseCase useCase){
        return
        route(
                POST("v1/api/save/product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request
                        .bodyToMono(ProductDto.class)
                        .flatMap(productDto -> useCase.apply(productDto))
                        .flatMap(productDtoMono -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDtoMono))
        );
    }
}

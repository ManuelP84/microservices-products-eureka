package com.sofkaU.productmicroservice.routes;

import com.sofkaU.productmicroservice.dto.ProductDto;
import com.sofkaU.productmicroservice.usecases.GetAllProductsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.function.BodyInserters;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllProductsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllProductsRouter(GetAllProductsUseCase useCase){
        return route(
                GET("v1/api/products").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCase.get(), ProductDto.class))
        );
    }
}

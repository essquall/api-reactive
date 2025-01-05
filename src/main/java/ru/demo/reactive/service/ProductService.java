package ru.demo.reactive.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ru.demo.reactive.dto.ProductDTO;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient client;

    public Mono<ProductDTO> getProductById(Long id) {
        return client.get()
                .uri("https://api.restful-api.dev/objects/" + id)
                .retrieve()
                .bodyToMono(ProductDTO.class)
                .retry();
    }
}

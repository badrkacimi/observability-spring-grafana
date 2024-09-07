package net.badr.observability.api;

import net.badr.observability.data.Post;
import net.badr.observability.data.Product;
import net.badr.observability.repository.ProductRepository;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
public class ProductController {
    private final ProductRepository productRepository;
    private RestClient client;

    public ProductController(ProductRepository productRepository, RestClient.Builder client) {
        this.productRepository = productRepository;
        this.client = client
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .build();
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/remote/posts")
    public List<Post> getAllPosts() {
        return client
                .get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<List<Post>>() {
                });

    }
}

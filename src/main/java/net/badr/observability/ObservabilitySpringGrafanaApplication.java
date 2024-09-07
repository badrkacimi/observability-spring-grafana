package net.badr.observability;

import net.badr.observability.data.Product;
import net.badr.observability.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObservabilitySpringGrafanaApplication {


    public static void main(String[] args) {
        SpringApplication.run(ObservabilitySpringGrafanaApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder().name("PC").price(4000).build());
            productRepository.save(Product.builder().name("Phone").price(400).build());
            productRepository.save(Product.builder().name("Printer").price(40).build());
            productRepository.findAll().forEach(System.out::println);
        };
    }
}

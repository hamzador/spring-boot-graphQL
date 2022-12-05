package org.dr.inventoryservice;

import org.dr.inventoryservice.entity.Category;
import org.dr.inventoryservice.entity.Product;
import org.dr.inventoryservice.repository.CategoryRepository;
import org.dr.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            if (categoryRepository.findAll().isEmpty() || productRepository.findAll().isEmpty()){
                List.of("computer", "Printer", "smartphone").forEach(
                        cat-> {
                            Category category = Category.builder().name(cat).build();
                            categoryRepository.save(category);
                        });
                categoryRepository.findAll().forEach(
                        category -> {
                            Random random = new Random();
                            for (int i = 0; i < 10; i++){
                                Product product = Product.builder()
                                        .name("computer " + i)
                                        .price(100 + Math.random()*5000)
                                        .quantity(100 + random.nextInt(100))
                                        .category(category)
                                        .build();
                                productRepository.save(product);
                            }
                        });

            }
        };
    }

}

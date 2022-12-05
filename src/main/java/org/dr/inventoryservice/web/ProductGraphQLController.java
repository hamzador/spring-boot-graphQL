package org.dr.inventoryservice.web;

import lombok.extern.java.Log;
import org.dr.inventoryservice.dto.ProductRequestDTO;
import org.dr.inventoryservice.entity.Category;
import org.dr.inventoryservice.entity.Product;
import org.dr.inventoryservice.repository.CategoryRepository;
import org.dr.inventoryservice.repository.ProductRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class ProductGraphQLController {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductGraphQLController(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @QueryMapping
    public List <Product> productList(){
        return productRepository.findAll();
    }

    @QueryMapping
    public Product productById(@Argument Long id){
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Product with code %s not found", id))
        );
    }

    @QueryMapping
    public List <Category> categoryList(){
        return categoryRepository.findAll();
    }

    @QueryMapping
    public Category categoryById(@Argument Long id){
        return categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Category with code %s not found", id))
        );
    }

    @MutationMapping
    public Product saveProduct(@Argument ProductRequestDTO productRequestDTO){
        Product product = new Product();
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElse(null);
//        if (category != null)
        product.setCategory(category);
        product.setName(productRequestDTO.name());
        product.setPrice(productRequestDTO.price());
        product.setQuantity(productRequestDTO.quantity());

        return productRepository.save(product);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long idProduct, @Argument ProductRequestDTO productRequestDTO){
        Product product = new Product();
        product = productRepository.findById(idProduct).get();
        Category category = categoryRepository.findById(productRequestDTO.categoryId()).orElse(null);
//        if (category != null)
        //product.setIdProduct(idProduct);
        product.setCategory(category);
        product.setName(productRequestDTO.name());
        product.setPrice(productRequestDTO.price());
        product.setQuantity(productRequestDTO.quantity());

        return productRepository.save(product);
    }

    @MutationMapping
    public void deleteProduct(@Argument Long id){
         productRepository.deleteById(id);
    } 
}

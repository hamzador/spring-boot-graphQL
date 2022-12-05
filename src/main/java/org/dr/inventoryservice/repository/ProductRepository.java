package org.dr.inventoryservice.repository;

import org.dr.inventoryservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}

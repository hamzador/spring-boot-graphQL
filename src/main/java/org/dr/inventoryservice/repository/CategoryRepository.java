package org.dr.inventoryservice.repository;

import org.dr.inventoryservice.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

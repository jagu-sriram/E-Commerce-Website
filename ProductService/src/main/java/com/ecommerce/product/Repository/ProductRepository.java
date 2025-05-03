package com.ecommerce.product.Repository;

import com.ecommerce.product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom methods can be added later (e.g., findByName, findByCategory, etc.)
}

package com.ecommerce.product.Repository;

import com.ecommerce.product.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Optional: findByName(String name) if needed later
}

package com.ecommerce.product.Service;

import com.ecommerce.product.Entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);
    List<Product> searchByName(String name);

    List<Product> filterByCategory(String category);

    List<Product> filterByPriceRange(double minPrice, double maxPrice);

    Page<Product> getPaginatedProducts(int page, int size, String sortBy, String sortDir);
}

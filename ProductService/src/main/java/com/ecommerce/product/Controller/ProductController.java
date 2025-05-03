package com.ecommerce.product.Controller;

import com.ecommerce.product.Entity.Product;
import com.ecommerce.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // 1. Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // 2. Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    // 3. Add new product
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }

    // 4. Update product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

    // 5. Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // 🔍 Search by name
    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchByName(@RequestParam String name) {
        // TODO: Implement this in service
        return ResponseEntity.ok(productService.searchByName(name));
    }

    // 📂 Filter by category
    @GetMapping("/category")
    public ResponseEntity<List<Product>> filterByCategory(@RequestParam String category) {
        // TODO: Implement this in service
        return ResponseEntity.ok(productService.filterByCategory(category));
    }

    // 💰 Filter by price range
    @GetMapping("/filter/price")
    public ResponseEntity<List<Product>> filterByPriceRange(
            @RequestParam double minPrice,
            @RequestParam double maxPrice
    ) {
        // TODO: Implement this in service
        return ResponseEntity.ok(productService.filterByPriceRange(minPrice, maxPrice));
    }

    // 📄 Pagination and sorting
    @GetMapping("/paginated")
    public ResponseEntity<Page<Product>> getPaginatedProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir
    ) {
        // TODO: Implement this in service
        return ResponseEntity.ok(productService.getPaginatedProducts(page, size, sortBy, sortDir));
    }
}

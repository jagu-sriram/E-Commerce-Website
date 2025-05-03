package com.ecommerce.product.Service;

import com.ecommerce.product.Entity.Product;
import com.ecommerce.product.Exception.ProductNotFoundException;
import com.ecommerce.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + id));
    }


    @Override
    public List<Product> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all;
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product existing = getProductById(id);
        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setImageUrl(updatedProduct.getImageUrl());
        existing.setPrice(updatedProduct.getPrice());
        existing.setQuantity(updatedProduct.getQuantity());
        existing.setCategory(updatedProduct.getCategory());
        return productRepository.save(existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Override
    public List<Product> searchByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> filterByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        return List.of();
    }

    @Override
    public Page<Product> getPaginatedProducts(int page, int size, String sortBy, String sortDir) {
        return null;
    }


}

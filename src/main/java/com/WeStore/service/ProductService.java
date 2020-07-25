package com.WeStore.service;

import com.WeStore.entity.Product;
import com.WeStore.entity.ProductCategory;
import com.WeStore.repository.ProductCategoryRepository;
import com.WeStore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final  ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductCategoryRepository productCategoryRepository) {
        this.productRepository = productRepository;
        this.productCategoryRepository = productCategoryRepository;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<ProductCategory> findAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    public List<Product> getByProductCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public List<Product> getProductByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public  Page<Product> findAllByPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public void add(String name){
        Product product = new Product();
        product.setName(name);
        productRepository.save(product);
    }
}

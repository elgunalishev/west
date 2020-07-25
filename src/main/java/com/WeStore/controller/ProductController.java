package com.WeStore.controller;

import com.WeStore.entity.Product;
import com.WeStore.entity.ProductCategory;
import com.WeStore.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public List<Product> getProducts() {
        return productService.findAllProduct();
    }

    @GetMapping("/product")
    public Product getProductById(@RequestParam("id") Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/productsCategory")
    public List<ProductCategory> getProductsCategory() {
        return productService.findAllProductCategory();
    }

    @GetMapping("/product/category")
    public List<Product> getProductByCategoryId(@RequestParam("id") Long categoryId) {
        return productService.getByProductCategoryId(categoryId);
    }

    @GetMapping(value = "/products",params = {"page","size"})
    public Page<Product> fetchByPage(@RequestParam("page") int page,
                                     @RequestParam("size") int size, Pageable pageable) {
        return productService.findAllByPage(pageable);
    }

    @GetMapping("/product/name")
    public List<Product> getProductByName(@RequestParam("name") String name) {
        return productService.getProductByName(name);
    }

    @PostMapping("/product/add")
    public ResponseEntity addProductByName(@RequestParam("name") String name) {
        productService.add(name);
        return ResponseEntity.ok().build();
    }



}



package com.WeStore.repository;

import com.WeStore.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product,Long>, PagingAndSortingRepository<Product,Long> {
    List<Product> findByCategoryId(Long id);
    Page<Product> findAll(Pageable pageable);
    List<Product> findByNameContaining(String name);
}

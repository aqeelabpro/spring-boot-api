package com.boot.repository;

import com.boot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAll(Pageable pageable);
    Product findFirstByNameLike(String name);
    Product findProductByNameLike(String name);
}

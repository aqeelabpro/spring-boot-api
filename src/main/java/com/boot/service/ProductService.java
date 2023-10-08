package com.boot.service;

import com.boot.entity.Product;
import com.boot.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Page<Product> findAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAll(pageable);
    }
    public List<Product> getAllProducts(String sortBy) {
        Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortBy));
        Page<Product> page = productRepository.findAll(pageable);
        System.out.println(page.getTotalElements());
        return page.getContent();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveAll(List<Product> products){
        return productRepository.saveAll(products);
    }

    public Product findProductDetails(String name){
        return productRepository.findProductByNameLike(name);
    }
}

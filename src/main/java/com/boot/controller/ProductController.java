package com.boot.controller;

import com.boot.entity.Product;
import com.boot.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Product>> getAllItems(@RequestParam(defaultValue = "id") String sortBy) {
        List<Product> items = productService.getAllProducts(sortBy);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Product>> getAllItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Product> items = productService.findAll(page, size);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


    @PostMapping("/create/all")
    public ResponseEntity<List<Product>> saveAll(@RequestBody List<Product> products) {
        List<Product> savedProducts = productService.saveAll(products);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    @GetMapping(value = "/like")
    public ResponseEntity<Product> findFirstByNameLike(@RequestParam("name") String name){
        return ResponseEntity.ok(productService.findProductDetails(name));
    }

}

package com.multipolar.bootcamp.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/product")
    public ResponseEntity<List<Product>> products(){
        List<Product> productList = List.of(
                new Product(1,"Smartphone"),
                new Product(2,"Laptop"),
                new Product(3,"Tablet"));
        return ResponseEntity.ok(productList);
    }
}

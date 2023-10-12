package com.multipolar.bootcamp.product.controller;


import com.multipolar.bootcamp.product.domain.Product;
import com.multipolar.bootcamp.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //input data
    @PostMapping
    public Product createProduct(@RequestBody Product product) { return productService.createOrUpdateProduct(product); }

    //display all data
    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }

    //display data by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        Optional<Product> product = productService.getProductByID(id);
        return product.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    //edit data
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product){
        product.setId(id);
        return  productService.createOrUpdateProduct(product);
    }

    //delete data
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable String id){
        productService.deleteProductById(id);
        return ResponseEntity.notFound().build();
    }


}

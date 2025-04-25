package com.redis.controller;

import com.redis.entity.Product;
import com.redis.service.ProductService;
import com.redis.service.ProductServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud")
public class ProductCrudRepository {
    @Autowired
    ProductServiceCrud productService;
    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }
    @GetMapping("/id/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(int id){
        return productService.deleteProduct(id);

    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }
}

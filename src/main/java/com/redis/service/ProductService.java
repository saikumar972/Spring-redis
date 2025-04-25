package com.redis.service;

import com.redis.dao.ProductRepo;
import com.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public Product saveProduct(Product product){
        return productRepo.saveProduct(product);
    }

    public Product getProductById(int id){
        return productRepo.getProductById(id);
    }

    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    }

    public String deleteProduct(int id){
        return productRepo.deleteProduct(id);

    }

    public Product updateProduct(Product product){
        return productRepo.updateProduct(product);
    }
}

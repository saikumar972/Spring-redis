package com.redis.dao;

import com.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo {
    private static final String REDIS_HASH_KEY="product_hash";
    @Autowired
    private RedisTemplate redisTemplate;

    public Product saveProduct(Product product){
        redisTemplate.opsForHash().put(REDIS_HASH_KEY,product.getId(),product);
        return product;
    }

    public Product getProductById(int id){
        return (Product)redisTemplate.opsForHash().get(REDIS_HASH_KEY,id);
    }

    public List<Product> getAllProducts(){
        return redisTemplate.opsForHash().values(REDIS_HASH_KEY);
    }

    public String deleteProduct(int id){
        redisTemplate.opsForHash().delete(REDIS_HASH_KEY,id);
        return "deleted";
    }

    public Product updateProduct(Product product){
        Product existingProduct=getProductById(product.getId());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        redisTemplate.opsForHash().put(REDIS_HASH_KEY,existingProduct.getId(),existingProduct);
        return product;
    }
}

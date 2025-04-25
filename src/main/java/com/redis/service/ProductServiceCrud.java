package com.redis.service;

import com.redis.dao.ProductDao;
import com.redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceCrud {
    @Autowired
    ProductDao productDao;

    public Product saveProduct(Product product){
        return productDao.save(product);
    }

    public Product getProductById(int id){
        return productDao.findById(id).orElseThrow(()->new IllegalArgumentException("no such id obj present"));
    }

    public List<Product> getAllProducts(){
        return (List<Product>) productDao.findAll();
    }

    public String deleteProduct(int id){
         productDao.deleteById(id);
         return "delete the product having id "+id;

    }

    public Product updateProduct(Product product){
        Product existingProduct=getProductById(product.getId());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        productDao.save(product);
        return existingProduct;
    }
}

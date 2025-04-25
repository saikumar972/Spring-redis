package com.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.lang.annotation.Documented;

@AllArgsConstructor
@NoArgsConstructor
@Data
@RedisHash(value="product_hash")
public class Product implements Serializable {
    private static final long serialVersionUId=1L;
    @Id
    private int id;
    private String name;
    private double price;
}

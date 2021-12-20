package com.hoaipx.learn2021.dao.redis;

import com.hoaipx.learn2021.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAO {

    private static final String HASH_KEY = "Product";

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public Product save(Product product) {
        template.opsForHash().put(HASH_KEY, product.getId(), product);
        return product;
    }

    public List<Product> findAll() {
        return template.opsForHash().values(HASH_KEY);
    }

    public Object findById(int id) {
        System.out.println("called findProductById() from DB");
        return template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteById(int id) {
        template.opsForHash().delete(HASH_KEY, id);
        return "Removed";
    }

}

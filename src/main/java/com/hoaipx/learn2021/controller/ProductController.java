package com.hoaipx.learn2021.controller;

import com.hoaipx.learn2021.dao.redis.ProductDAO;
import com.hoaipx.learn2021.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductDAO productDAO;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Product product) {
        return ResponseEntity.ok(productDAO.save(product));
    }

    @GetMapping("/list")
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(productDAO.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable int id) {
        return ResponseEntity.ok(productDAO.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delId(@PathVariable int id) {
        return ResponseEntity.ok(productDAO.deleteById(id));
    }

}

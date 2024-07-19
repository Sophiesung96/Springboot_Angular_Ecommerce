package com.example.springbootangularecommerce.dao;

import com.example.springbootangularecommerce.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}

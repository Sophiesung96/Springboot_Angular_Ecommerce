package com.example.springbootangularecommerce.dao;

import com.example.springbootangularecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Customer findByEmail(String email);
}

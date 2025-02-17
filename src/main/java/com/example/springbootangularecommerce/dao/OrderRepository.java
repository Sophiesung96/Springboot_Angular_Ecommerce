package com.example.springbootangularecommerce.dao;

import com.example.springbootangularecommerce.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource()
public interface OrderRepository  extends JpaRepository<Order, Long> {
    Page<Order> findByCustomerEmail(String email, Pageable pageable);


}

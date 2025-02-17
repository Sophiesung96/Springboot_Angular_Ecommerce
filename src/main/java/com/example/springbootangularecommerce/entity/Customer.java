package com.example.springbootangularecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Customer", description = "Represents a customer entity in the system")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the customer.")
    private Long id;
    @Column(name = "first_name")
    @Schema(description = "Customer's first name", example = "John")
    private String firstName;
    @Column(name = "last_name")
    @Schema(description = "Customer's last name", example = "Doe")
    private String lastName;
    @Column(name = "email")
    @Schema(description = "Customer's email", example = "john.doe@example.com")
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(description = "List of orders associated with the customer")
    private List<Order> orders=new ArrayList<>();

    public void add(Order order) {
        if(order!=null){
            if(orders==null)
            {
                orders = new ArrayList<>();
            }
            orders.add(order);
            order.setCustomer(this);
        }
    }
}

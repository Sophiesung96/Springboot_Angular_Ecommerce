package com.example.springbootangularecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the order item.")
    private Long id;
    @Column(name = "image_url")
    @Schema(description = "URL of the product image.")
    private String imageUrl;
    @Column(name = "quantity")
    @Schema(description = "Quantity of the product ordered.")
    private int quantity;
    @Column(name = "unit_price")
    @Schema(description = "Unit price of the product.")
    private int unitPrice;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    @Schema(description = "The order that this item belongs to.")
    private Order  order;


}

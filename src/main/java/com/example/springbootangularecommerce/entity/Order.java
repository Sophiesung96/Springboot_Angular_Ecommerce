package com.example.springbootangularecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Order", description = "Represents an order placed by a customer.")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Schema(description = "Unique identifier for the order.")
    private Long id;
    @Column(name = "order_tracking_number")
    @Schema(description = "Tracking number for the order.", example = "TRK123456789")
    private  String orderTrackingNumber;
    @Column(name = "total_quantity")
    @Schema(description = "Total quantity of items in the order.")
    private int totalQuantity;
    @Column(name = "total_price")
    @Schema(description = "Total price of the order.")
    private BigDecimal totalPrice;
    @Column(name = "status")
    @Schema(description = "Current status of the order.")
    private  String status;
    @Column(name = "date_created")
    @CreationTimestamp
    @Schema(description = "Timestamp when the order was created.")
    private Date dateCreated;
    @Column(name = "last_created")
    @UpdateTimestamp
    @Schema(description = "Timestamp when the order was last updated.")
    private Date lastUpdated;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    @Schema(description = "List of items associated with the order.")
    private List<OrderItem> orderItems=new ArrayList<>();

    public void add(OrderItem orderItem) {
        if(orderItem!=null)
        {
            if(orderItems==null)
            {
                orderItems=new ArrayList<>();
            }
            orderItems.add(orderItem);
            orderItem.setOrder(this);
        }
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "shipping_address_id", referencedColumnName = "id")
    @Schema(description = "Shipping address associated with the order.")
    private Address shippingAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billing_address_id", referencedColumnName = "id")
    @Schema(description = "Billing address associated with the order.")
    private Address billingAddress;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @Schema(description = "The customer who placed the order.")
    private Customer customer;

}

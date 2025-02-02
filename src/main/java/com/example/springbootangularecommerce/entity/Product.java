package com.example.springbootangularecommerce.entity;
import com.example.springbootangularecommerce.entity.*;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Product entity")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique identifier of the product",example = "1",required = true)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @Schema(description = "Product's category",example = "Mugs",required = true)
    private ProductCategory category;

    @Column(name = "sku",nullable = false)
    @Schema(description = "sku",required = true)
    private String sku;

    @Column(name = "name",nullable = false)
    @Schema(description = "Product's name",example = "The introduction of JAVA 8",required = true)
    private String name;

    @Column(name = "description")
    @Schema(description = "Product's description", example = "This book is about JAVA　８",required = true)
    private String description;

    @Column(name = "unit_price",nullable = false)
    @Schema(description = "Product's unit price",example = "$20.99",required = true)
    private BigDecimal unitPrice;

    @Column(name = "image_url")
    @Schema(description = "Product's image Url",example = "example.png",required = true)
    private String imageUrl;

    @Column(name = "active")
    @Schema(description = "Product's status",example = "true",required = true)
    private boolean active;

    @Column(name = "units_in_stock",nullable = false)
    @Schema(description = "Product's units in stock",example = "1",required = true)
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    @Schema(description = "The date when the product was created",example = "04/05/2020",required = true)
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    @Schema(description = "The date when the product was last updated",example = "06/08/2020",required = true)
    private Date lastUpdated;
}
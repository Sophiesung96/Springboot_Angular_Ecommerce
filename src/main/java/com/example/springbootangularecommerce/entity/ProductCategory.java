package com.example.springbootangularecommerce.entitiy;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="product_category")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique identifier of Product's Category",required = true)
    private Long id;

    @Column(name = "category_name")
    @Schema(description = "The Category's name",required = true)
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    @Schema(description = "Many products can be categorised by a category",required = true)
    private Set<Product> products;

}


package com.example.springbootangularecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier for the address.")
    private Long id;
    @Column(name = "street")
    @Schema(description = "Street name for the address.")
    private String street;
    @Schema(description = "City of the address.")
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    @Schema(description = "State or Region of the address.")
    private String state;
    @Column(name = "country")
    @Schema(description = "Country of the address.")
    private String country;
    @Column(name = "zip_code")
    @Schema(description = "Zip or Postal Code of the address.")
    private String zipcode;


}

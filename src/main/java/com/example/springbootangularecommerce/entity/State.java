package com.example.springbootangularecommerce.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;

@Entity
@Table(name="state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class State  {

    //When to annotate a variable with @JoinColumn and @ManyToOne:
    //The entity that has direct control over the relationship.
    //It contains the foreign key column in the database.
    //It is responsible for the actual linkage between the entities.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique identifier of State",required = true)
    private Integer id;
    @Column(name = "name")
    @Schema(description = "The name of the state",example = "New York", required = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    @Schema(description = "A country comprises of many states",required = true)
    private Country country;

}

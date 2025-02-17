package com.example.springbootangularecommerce.entity;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Entity
@Table(name="country")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique identifier of Country", required = true)
    private Integer id;

    @Column(name = "name")
    @Schema(description = "The Country's name", example = "The United States of America", required = true)
    private  String name;

    @Column(name = "code")
    @Schema(description = "The Country's code", required = true)
    private String code;

    @OneToMany(mappedBy = "country")
    @Schema(description = "The states belong to the Country", required = true)
    private  List<State> states;



}


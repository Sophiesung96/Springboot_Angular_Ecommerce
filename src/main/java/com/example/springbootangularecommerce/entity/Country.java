package com.example.springbootangularecommerce.entitiy;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;


@Entity
@Table(name="country")
@Getter
public class Country {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "The unique identifier of Country", required = true)
    private int id;

    @Column(name = "name")
    @Schema(description = "The Country's name", example = "The United States of America", required = true)
    private  String name;

    @Column(name = "code")
    @Schema(description = "The Country's code", required = true)
    private String code;

    @OneToMany(mappedBy = "country")
    @Schema(description = "The states belong to the Country", required = true)
    private  List<State> states;

    public Country(int id, String name, String code, List<State> states) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.states = states;
    }

    public Country() {
    }
}


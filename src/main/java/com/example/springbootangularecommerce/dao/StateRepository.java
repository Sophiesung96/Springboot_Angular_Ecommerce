package com.example.springbootangularecommerce.dao;

import com.example.springbootangularecommerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhsot:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

    Optional<List<State>> findByCountryCode(@Param("code") String countryCode);

}

package com.example.springbootangularecommerce;


import com.example.springbootangularecommerce.entity.Instructor;
import com.example.springbootangularecommerce.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.springbootangularecommerce.dao")
public class SpringbootAngularEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAngularEcommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> {
           // createInstructor(studentDAO);
           //findInstructor(1,studentDAO);
           //findInstructorDetail(2,studentDAO);

        };
    }





}

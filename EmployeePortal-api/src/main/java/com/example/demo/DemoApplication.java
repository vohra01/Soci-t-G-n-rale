package com.example.demo;

import com.example.bo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;


@SpringBootApplication
@ComponentScan("com.example")
@EntityScan("com.example")
@EnableJpaRepositories("com.example")
public class DemoApplication {

    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(DemoApplication.class, args);

        Employee emp = new Employee();
        emp.setFname("Kunal");
        emp.setLname("Vohra");
        emp.setDepartment("Information Technology");
        emp.setGender("Male");
        emp.setDob(new Date());

        System.out.println(new ObjectMapper().writeValueAsString(emp));
    }
}

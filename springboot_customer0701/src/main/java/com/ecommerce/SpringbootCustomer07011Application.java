package com.ecommerce;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

 

import com.ecommerce.dao.ICustomerRepository;
import com.ecommerce.model.Customer;

 

@SpringBootApplication
public class SpringbootCustomer07011Application {

    private static final Logger log = LoggerFactory.getLogger(SpringbootCustomer07011Application.class);

 

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCustomer07011Application.class, args);

    }
    @Bean
    public Customer getCustomer(ICustomerRepository repository){
       // return repository.save(new Customer(1, "Kunal Thakkekar", 8712789011L, "kunalthakkekar56@gmail.com", "35,Ram Vilas Wada, Thane"));
         return repository.save(new Customer(5, "Anwesha Das", 9812679812L, "anudas78@gmail.com", "23 , Das Villas , Kolkata"));
    }

 

}
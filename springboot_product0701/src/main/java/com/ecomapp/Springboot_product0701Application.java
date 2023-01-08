package com.ecomapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ecomapp.dao.IProductRepository;
import com.ecomapp.model.Product;

@SpringBootApplication
public class Springboot_product0701Application {
	
	private static final Logger log = LoggerFactory.getLogger(Springboot_product0701Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Springboot_product0701Application.class, args);
	}
	
//	@Bean
//	public Product getProduct(IProductRepository repository){
//	   
//		 return repository.save(new Product(1L, "Polo Tshirt","Polo.jpg",600,1,"100 % Cotton"));
//	}

}

package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//http://localhost:3000/api/books
import com.ecommerce.dto.ProductData;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {


	@Autowired
	private ProductService productService;
	@GetMapping
	public List<ProductData> findAll() {
		return productService.findAll();
	}
	@GetMapping("/product/{id}")
	public ProductData findById(@PathVariable  Long id) {
		return productService.findById(id);
	}
	@PostMapping("/product")
	public ProductData create(@RequestBody 	ProductData productData) {
		return productService.create(productData);
	}
	@DeleteMapping("/product/{id}")
	public boolean delete(@PathVariable Long id) {
		return productService.delete(id);
	}

}

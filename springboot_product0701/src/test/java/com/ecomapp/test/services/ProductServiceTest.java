package com.ecomapp.test.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.ecomapp.dao.IProductRepository;
import com.ecomapp.dto.ProductData;
import com.ecomapp.model.Product;
import com.ecomapp.service.ProductService;

	
	@SpringBootTest
	public class ProductServiceTest {

		@Autowired
	    private ProductService productServices;

	    @Autowired
	    private ProductData productData;

	    @Autowired
	    private Product product;

	    @Autowired
	    private IProductRepository productRepository;

	    @BeforeAll
	    static void beforeAll() {
	        System.out.println("@BeforeAll");
	    }

	   
	    @BeforeEach()
	    public void beforeEach()
	    {
	        productData=new ProductData("Polo  Tshirt","Polo.jpg",600,1,"100% Cotton");
	    }

	    
	    @Test
	    public void testCreateProduct() {
	        Assertions.assertNotNull(productServices.create(productData));
	    }

	    @Disabled
	     @Test
	     public void testFindAllNotNull() {
	         Assertions.assertNotNull(productServices.findAll());
	     }

	     @Disabled
	     @Test
	     public void testFindOneNotNull() {
	         Long id=(long) 7;
	         productData = productServices.findById(id);
	         System.out.println("id=7 |" + productData);

	         Assertions.assertNotNull(productData);
	     }

	    
	     @Test
	         public void testFindOneAndDelete() {
	         Assertions.assertFalse(productServices.delete((long) 9));
	     }

	     @Disabled
	     @Test
	     public void testFindOneAndUpdate() {
	         Long id=9l;
	         productData.setProduct("Allen Solly");
	         Assertions.assertNotNull(productServices.updateProductById(productData, id));
	     }
		
	}




package com.ecommerce.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.IProductRepository;
import com.ecommerce.dto.ProductData;
import com.ecommerce.model.Product;

@Service
public class ProductService implements IProductService{



	@Autowired
	private IProductRepository productRepository;


//	DTO=>Entity
	private Product getProductEntity(ProductData productData) {
		Product product = new Product();
		product.setProductId(productData.getProductId());
		product.setProductName(productData.getProductName());
		product.setUnitPrice(productData.getUnitPrice());
		return product;
	}

//	Entity=>DTO
	private ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setUnitPrice(product.getUnitPrice());

		return productData;
	}

	@Override
	public List<ProductData> findAll() {
		List<ProductData> productDataList=new ArrayList<>();
		List<Product> products=productRepository.findAll();
		products.forEach(product->{productDataList.add(getProductData(product));});
		return productDataList;
	}

	@Override
	public ProductData findById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional == null) {
			new EntityNotFoundException("Product Not Found");
		}
		return getProductData(productOptional.get());
	}

	//Controller=>BookData(view)=>Entity=>repository=>Entity(c)/null=>BookData=>Controller=>View
	@Override
	public ProductData create(ProductData productData) {
		Product product=getProductEntity(productData);
		
		return getProductData(productRepository.save(product));
	}

	@Override
	public boolean delete(Long id) {
		boolean test=findAll().remove(findById(id));
		productRepository.deleteById(id);		
		return test;
	}
}

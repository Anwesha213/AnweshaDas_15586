package com.ecomapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecomapp.dao.IProductRepository;
import com.ecomapp.dto.ProductData;
import com.ecomapp.model.Product;



@Service
public class ProductService implements IProductServices {
	
	@Autowired
    private IProductRepository productRepository;

	private Product getProductEntity(ProductData productData) {
        Product product = new Product();
        product.setProductId(productData.getProductId());
        product.setProduct(productData.getProduct());
        product.setProductImage(productData.getProductImage());
        product.setUnitPrice(productData.getUnitPrice());
        product.setProductQty(productData.getProductQty());
        product.setProductDescription(productData.getProductDescription());
        return product;
    }

 
    private ProductData getProductData(Product product) {
        ProductData productData = new ProductData();
        productData.setProductId(product.getProductId());
        productData.setProduct(product.getProduct());
        productData.setProductImage(product.getProductImage());
        productData.setUnitPrice(product.getUnitPrice());
        productData.setProductQty(product.getProductQty());
        productData.setProductDescription(product.getProductDescription());
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
	

	  public ProductData updateProductById(ProductData productData, Long productId) {
	        Product product=productRepository.findById(productId).get();
	        if(product!=null) {
	            product.setProduct(productData.getProduct());
	            product.setProductImage(productData.getProductImage());
	            product.setUnitPrice(productData.getUnitPrice());
	            product.setProductQty(productData.getProductQty());
	            product.setProductDescription(productData.getProductDescription());

	 

	            productRepository.save(product);

	 

	            return  getProductData(product);
	        }
	        else {
	            return null;
	        }
 

	    }


	  
	  
	  
	  
	  
	  
	  
	  
	@Override
	public ProductData create() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

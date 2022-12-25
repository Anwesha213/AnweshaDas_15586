package com.ecommerce.product.controller;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.product.model.Product;
public class ProductController implements IController<Product>{


	private static ProductController productController;
	private ProductCollection productCollection;
	private ProductController() {
		super();
		this.productCollection=productCollection.getProductCollection();
	}
	public static ProductController getProductController() {
		if(productController==null) {
			synchronized(ProductController.class) {
				if(productController==null) {
					productController= new ProductController();
				}
			}
		}
		return productController;
	}
	public List<Product> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return productCollection.findAll();
	}
	public Product findOne(int id) throws SQLException {
	
		return productCollection.findOne(id);
	}
	public boolean createNew(Product product) throws SQLException {

		return productCollection.createNew(product);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return productCollection.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
	
		return productCollection.findOneAndUpdate(id, product);
	}
	
}

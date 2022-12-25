package com.ecommerce.product.controller;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.product.dao.ProductDao;
import com.ecommerce.product.dao.DbConnection;
import com.ecommerce.product.model.Product;
public class ProductCollection implements ICollection<Product>{


	private static ProductCollection collection;
	private ProductDao dao;
	private List<Product> productList;
//	private BankAccountCollection() throws SQLException {
//		this.dao = BankAccountDao.getBankAccountDao();
	//  this.accountList = dao.findAll();
//	}
	private ProductCollection() {
		this.dao = ProductDao.geProductDao();
	}
	public static ProductCollection getProductCollection() {
		if(collection==null) {
			synchronized (ProductCollection.class) {
				if(collection==null) {
					collection = new ProductCollection();
				}
			}
		}
		return collection;
	}
	public List<Product> findAll() throws SQLException {
		productList=dao.findAll();
		return productList;
	}
	public Product findOne(int id) throws SQLException {
		Product account = dao.findOne(id);
		return account;
	}
	
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return dao.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		
		return dao.findOneAndUpdate(id, product);
	}
	public boolean createNew(Product product) throws SQLException {
		
		return dao.createNew(product);
	}
}

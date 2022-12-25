package com.ecommerce.product.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.product.model.Product;
public class ProductDao implements IDao<Product>{


	private DbConnection db;
	private static ProductDao productDao;

	private ProductDao() {
		super();	
	}

	public ProductDao(DbConnection db) {
		super();
		this.db = db;
	}
	public static ProductDao geProductDao() {
		if(productDao==null) {
			synchronized (ProductDao.class) {
				if(productDao==null) {
					productDao = new ProductDao(DbConnection.getDb());
				}
			}
		}
		return productDao;
	}

	public List<Product> findAll() throws SQLException {
		final List<Product> list=new ArrayList<Product>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitPrice from product";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));			
		}
		return list;
	}

	public Product findOne(int id)  throws SQLException{
		
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select pid,pname,unitPrice from product where pid="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Product account=new Product(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
			return account;
		}
		return null;
	}

	public boolean createNew(Product account)  throws SQLException{
		Connection connect=db.getConnection();		
		final String sql="insert into product values(?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, account.getpid());
		pStatement.setString(2, account.getpname());
		pStatement.setInt(3,((int) account.getunitPrice()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from product where pid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Product product) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update product set unitPrice=? where pid=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, ((int)product.getunitPrice()));
		pStatement.setInt(2, product.getpid());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	
}

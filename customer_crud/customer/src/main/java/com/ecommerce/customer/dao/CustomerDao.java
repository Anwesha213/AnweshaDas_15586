package com.ecommerce.customer.dao;
import com.ecommerce.customer.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements IDao<Customer> {



	private DbConnection db;
	private static CustomerDao customerDao;

	private CustomerDao() {
		super();	
	}

	public CustomerDao(DbConnection db) {
		super();
		this.db = db;
	}
	public static CustomerDao geProductDao() {
		if(customerDao==null) {
			synchronized (CustomerDao.class) {
				if(customerDao==null) {
					customerDao = new CustomerDao(DbConnection.getDb());
				}
			}
		}
		return customerDao;
	}

	public List<Customer> findAll() throws SQLException {
		final List<Customer> list=new ArrayList<Customer>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select custId,custName,phone,email from customer";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));			
		}
		return list;
	}

	public Customer findOne(int id)  throws SQLException{
		
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select CustId,CustName,phone,email from customer where custId="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Customer customer=new Customer(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
			return customer;
		}
		return null;
	}

	public boolean createNew(Customer customer)  throws SQLException{
		Connection connect=db.getConnection();		
		final String sql="insert into customer values(?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, customer.getcustId());
		pStatement.setString(2, customer.getcustName());
		pStatement.setString(3, customer.getphone());
		pStatement.setString(4, customer.getemail());
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from customer where custId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update customer set custName=? where custId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setString(1, customer.getcustName());
		pStatement.setInt(2, customer.getcustId());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	
}

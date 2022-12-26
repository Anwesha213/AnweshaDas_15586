package com.ecommerce.customer.controller;

import java.sql.SQLException;
import java.util.List;

import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.dao.DbConnection;
import com.ecommerce.customer.model.Customer;
public class CustomerCollection implements ICollection<Customer> {



	private static CustomerCollection collection;
	private CustomerDao dao;
	private List<Customer> customerList;
//	private BankAccountCollection() throws SQLException {
//		this.dao = BankAccountDao.getBankAccountDao();
	//  this.accountList = dao.findAll();
//	}
	private CustomerCollection() {
		this.dao = CustomerDao.geProductDao();
	}
	public static CustomerCollection getCustomerCollection() {
		if(collection==null) {
			synchronized (CustomerCollection.class) {
				if(collection==null) {
					collection = new CustomerCollection();
				}
			}
		}
		return collection;
	}
	public List<Customer> findAll() throws SQLException {
		customerList=dao.findAll();
		return customerList;
	}
	public Customer findOne(int id) throws SQLException {
		Customer customer = dao.findOne(id);
		return customer;
	}
	
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return dao.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Customer customer) throws SQLException {
		
		return dao.findOneAndUpdate(id, customer);
	}
	public boolean createNew(Customer customer) throws SQLException {
		
		return dao.createNew(customer);
	}
}

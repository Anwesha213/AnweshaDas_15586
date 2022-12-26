package com.ecommerce.customer;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.customer.controller.CustomerController;
import com.ecommerce.customer.dao.CustomerDao;
import com.ecommerce.customer.dao.DbConnection;
import com.ecommerce.customer.model.Customer;
public class CustomerApp {


	public static void main(String[] args) {
		try {
			final CustomerController customerController = 
					CustomerController.getCustomerController();
		    System.out.println("1. Display all Customers");
		    System.out.println("2. Customer Details by custId");
		    System.out.println("3. Delete Customer by custId");
		    System.out.println("4. Update custName by custId");
			int choice=1;
			System.out.println("1. Display all Customers");
			mainOptions(customerController, choice);
			System.out.println("2. Customer Details by custId");
			choice=2;
			mainOptions(customerController, choice);
			
			System.out.println("3. Delete Customer by custId");
			choice=3;
			mainOptions(customerController, choice);
			
			System.out.println("4. Update custName by pid");
			choice=4;
			mainOptions(customerController, choice);
			choice=1;
			System.out.println("1. Display all Customers");
			mainOptions(customerController, choice);
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			final DbConnection db=DbConnection.getDb();
			final CustomerDao dao=new CustomerDao(db);
//			Display all products			
			printCustomers(dao);
//			Find by custId
			System.out.println("Find Customers by custId");
			final Customer customer=dao.findOne(1);
			System.out.println(customer);
//			Create new Product
			System.out.println("After New customer added");
			final Customer newCustomer=new Customer("Max","6364659263","max12@gmail.com");
			if(dao.createNew(newCustomer)) {
				System.out.println(newCustomer+" Created ");
			}else {
				System.out.println(newCustomer+" Not Created ");
			}
			
			printCustomers(dao);
			System.out.println("After Delete");
			if(dao.findOneAndDelete(0)) {
				System.out.println("custId : 0 records deleted");
			}
			printCustomers(dao);
			System.out.println("After update");
			customer.setcustName("John");
			if(dao.findOneAndUpdate(1,customer)) {
				System.out.println(customer+" updated");
			}
			printCustomers(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final CustomerController customerController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<Customer> list = customerController.findAll();
			for(Customer customer:list) {
				System.out.println(customer);
			}
			break;
		case 2: 
			final Customer customer = customerController.findOne(1);
			System.out.println(customer);
			
			break;
		case 3: 
			if(customerController.findOneAndDelete(3)) {
				System.out.println("custId: 3 Records Deleted");
			}
			
			break;
		case 4:
			final Customer updateCustomer = customerController.findOne(1);
			updateCustomer.setcustName("Jake");
			if(customerController.findOneAndUpdate(3,updateCustomer)) {
				System.out.println("custId: 3 Records Updated");
			}
			break;
		case 5:
			final Customer newCustomer = new Customer("Justin", "9896368798", "justin09@gmail.com");
			if(customerController.createNew(newCustomer)) {
				System.out.println(newCustomer + " Created in DB");
			}
			break;
		default:
			System.out.println("Please select 1 to 5 options");
			break;
		}
	}

	private static void printCustomers(CustomerDao dao) throws SQLException {
		final List<Customer> list=dao.findAll();
		for(Customer a: list) {
			System.out.println(a);
		}
	}

}

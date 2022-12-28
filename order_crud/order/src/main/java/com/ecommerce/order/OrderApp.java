package com.ecommerce.order;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.order.controller.OrderController;
import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.dao.DbConnection;
import com.ecommerce.order.model.Order;

public class OrderApp {


	public static void main(String[] args) {
		try {
			final OrderController orderController = 
					OrderController.getOrderController();
		    System.out.println("1. Display all Order");
		    System.out.println("2. Order Details by orderId");
		    System.out.println("3. Delete Order by orderId");
		    System.out.println("4. Update orderDate by orderId");
			int choice=1;
			System.out.println("1. Display all Orders");
			mainOptions(orderController, choice);
			System.out.println("2. Order Details by orderId");
			choice=2;
			mainOptions(orderController, choice);
			
			System.out.println("3. Delete Order by orderId");
			choice=3;
			mainOptions(orderController, choice);
			
			System.out.println("4. Update orderDate by orderId");
			choice=4;
			mainOptions(orderController, choice);
			choice=1;
			System.out.println("1. Display all OrderItems");
			mainOptions(orderController, choice);
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			final DbConnection db=DbConnection.getDb();
			final OrderDao dao=new OrderDao(db);
//			Display all products			
			printOrders(dao);
//			Find by pid
			System.out.println("Find Orders by orderId");
			final Order order=dao.findOne(1);
			System.out.println(order);
//			Create new Product
			System.out.println("After New order added");
			final Order newOrder=new Order(3,2,"2022-12-29",200000);
			if(dao.createNew(newOrder)) {
				System.out.println(newOrder+" Created ");
			}else {
				System.out.println(newOrder+" Not Created ");
			}
			
			printOrders(dao);
			System.out.println("After Delete");
			if(dao.findOneAndDelete(0)) {
				System.out.println("orderId : 0 records deleted");
			}
			printOrders(dao);
			System.out.println("After update");
			order.setOrderDate("20-11-2022");
			if(dao.findOneAndUpdate(1,order)) {
				System.out.println(order+" updated");
			}
			printOrders(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final OrderController orderController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<Order> list = orderController.findAll();
			for(Order order:list) {
				System.out.println(order);
			}
			break;
		case 2: 
			final Order order = orderController.findOne(1);
			System.out.println(order);
			
			break;
		case 3: 
			if(orderController.findOneAndDelete(3)) {
				System.out.println("itemId: 3 Records Deleted");
			}
			
			break;
		case 4:
			final Order updateOrder = orderController.findOne(1);
			updateOrder.setOrderDate("20-11-2022");
			if(orderController.findOneAndUpdate(1,updateOrder)) {
				System.out.println("itemId: 3 Records Updated");
			}
			break;
		case 5:
			final Order newOrder = new Order(2,3,"2022-12-29",19636);
			if(orderController.createNew(newOrder)) {
				System.out.println(newOrder + " Created in DB");
			}
			break;
		default:
			System.out.println("Please select 1 to 5 options");
			break;
		}
	}

	private static void printOrders(OrderDao dao) throws SQLException {
		final List<Order> list=dao.findAll();
		for(Order a: list) {
			System.out.println(a);
		}
	}

}

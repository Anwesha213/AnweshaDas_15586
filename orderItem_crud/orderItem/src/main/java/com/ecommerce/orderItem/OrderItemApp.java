package com.ecommerce.orderItem;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.orderItem.controller.OrderItemController;
import com.ecommerce.orderItem.dao.OrderItemDao;
import com.ecommerce.orderItem.dao.DbConnection;
import com.ecommerce.orderItem.model.OrderItem;

public class OrderItemApp {


	public static void main(String[] args) {
		try {
			final OrderItemController orderItemController = 
					OrderItemController.getOrderItemController();
		    System.out.println("1. Display all OrderItems");
		    System.out.println("2. OrderItem Details by itemId");
		    System.out.println("3. Delete OrderItem by itemId");
		    System.out.println("4. Update quantity by itemId");
			int choice=1;
			System.out.println("1. Display all OrderItems");
			mainOptions(orderItemController, choice);
			System.out.println("2. OrderItem Details by itemId");
			choice=2;
			mainOptions(orderItemController, choice);
			
			System.out.println("3. Delete OrderItem by itemId");
			choice=3;
			mainOptions(orderItemController, choice);
			
			System.out.println("4. Update quantity by itemId");
			choice=4;
			mainOptions(orderItemController, choice);
			choice=1;
			System.out.println("1. Display all OrderItems");
			mainOptions(orderItemController, choice);
			
		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			final DbConnection db=DbConnection.getDb();
			final OrderItemDao dao=new OrderItemDao(db);
//			Display all products			
			printOrderItems(dao);
//			Find by pid
			System.out.println("Find OrderItems by itemId");
			final OrderItem orderItem=dao.findOne(1);
			System.out.println(orderItem);
//			Create new Product
			System.out.println("After New orderitem added");
			final OrderItem newOrderItem=new OrderItem(3,"Top",2,10000,20000);
			if(dao.createNew(newOrderItem)) {
				System.out.println(newOrderItem+" Created ");
			}else {
				System.out.println(newOrderItem+" Not Created ");
			}
			
			printOrderItems(dao);
			System.out.println("After Delete");
			if(dao.findOneAndDelete(0)) {
				System.out.println("itemId : 0 records deleted");
			}
			printOrderItems(dao);
			System.out.println("After update");
			orderItem.setQuantity(5);
			if(dao.findOneAndUpdate(1,orderItem)) {
				System.out.println(orderItem+" updated");
			}
			printOrderItems(dao);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void mainOptions(final OrderItemController orderItemController, int choice) throws SQLException {
		switch(choice) {
		case 1: 
			List<OrderItem> list = orderItemController.findAll();
			for(OrderItem orderItem:list) {
				System.out.println(orderItem);
			}
			break;
		case 2: 
			final OrderItem orderItem = orderItemController.findOne(1);
			System.out.println(orderItem);
			
			break;
		case 3: 
			if(orderItemController.findOneAndDelete(3)) {
				System.out.println("itemId: 3 Records Deleted");
			}
			
			break;
		case 4:
			final OrderItem updateOrderItem = orderItemController.findOne(1);
			updateOrderItem.setQuantity(5);
			if(orderItemController.findOneAndUpdate(3,updateOrderItem)) {
				System.out.println("itemId: 3 Records Updated");
			}
			break;
		case 5:
			final OrderItem newOrderItem = new OrderItem(1,"Jeans and Yoga-pants",2, 9863, 19726);
			if(orderItemController.createNew(newOrderItem)) {
				System.out.println(newOrderItem + " Created in DB");
			}
			break;
		default:
			System.out.println("Please select 1 to 5 options");
			break;
		}
	}

	private static void printOrderItems(OrderItemDao dao) throws SQLException {
		final List<OrderItem> list=dao.findAll();
		for(OrderItem a: list) {
			System.out.println(a);
		}
	}

}

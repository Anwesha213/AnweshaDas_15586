package com.ecommerce.order.controller;


import java.sql.SQLException;
import java.util.List;
import com.ecommerce.order.model.Order;
public class OrderController implements IController<Order>{


	private static OrderController orderController;
	private OrderCollection orderCollection;
	private OrderController() {
		super();
		this.orderCollection=orderCollection.getOrderCollection();
	}
	public static OrderController getOrderController() {
		if(orderController==null) {
			synchronized(OrderController.class) {
				if(orderController==null) {
					orderController= new OrderController();
				}
			}
		}
		return orderController;
	}
	public List<Order> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return orderCollection.findAll();
	}
	public Order findOne(int id) throws SQLException {
	
		return orderCollection.findOne(id);
	}
	public boolean createNew(Order order) throws SQLException {

		return orderCollection.createNew(order);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return orderCollection.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Order order) throws SQLException {
	
		return orderCollection.findOneAndUpdate(id, order);
	}
	
}

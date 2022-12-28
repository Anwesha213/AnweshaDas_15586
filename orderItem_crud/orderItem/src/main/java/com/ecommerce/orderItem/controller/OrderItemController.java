package com.ecommerce.orderItem.controller;
import java.sql.SQLException;
import java.util.List;
import com.ecommerce.orderItem.model.OrderItem;
public class OrderItemController implements IController<OrderItem>{


	private static OrderItemController orderItemController;
	private OrderItemCollection orderItemCollection;
	private OrderItemController() {
		super();
		this.orderItemCollection=orderItemCollection.getOrderItemCollection();
	}
	public static OrderItemController getOrderItemController() {
		if(orderItemController==null) {
			synchronized(OrderItemController.class) {
				if(orderItemController==null) {
					orderItemController= new OrderItemController();
				}
			}
		}
		return orderItemController;
	}
	public List<OrderItem> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return orderItemCollection.findAll();
	}
	public OrderItem findOne(int id) throws SQLException {
	
		return orderItemCollection.findOne(id);
	}
	public boolean createNew(OrderItem product) throws SQLException {

		return orderItemCollection.createNew(product);
	}
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return orderItemCollection.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
	
		return orderItemCollection.findOneAndUpdate(id, orderItem);
	}
	
}

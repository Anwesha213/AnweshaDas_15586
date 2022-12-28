package com.ecommerce.orderItem.controller;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.orderItem.dao.OrderItemDao;
import com.ecommerce.orderItem.dao.DbConnection;
import com.ecommerce.orderItem.model.OrderItem;
public class OrderItemCollection implements ICollection<OrderItem>{



	private static OrderItemCollection collection;
	private OrderItemDao dao;
	private List<OrderItem> orderItemList;
//	private BankAccountCollection() throws SQLException {
//		this.dao = BankAccountDao.getBankAccountDao();
	//  this.accountList = dao.findAll();
//	}
	private OrderItemCollection() {
		this.dao = OrderItemDao.getOrderItemDao();
	}
	public static OrderItemCollection getOrderItemCollection() {
		if(collection==null) {
			synchronized (OrderItemCollection.class) {
				if(collection==null) {
					collection = new OrderItemCollection();
				}
			}
		}
		return collection;
	}
	public List<OrderItem> findAll() throws SQLException {
		orderItemList=dao.findAll();
		return orderItemList;
	}
	public OrderItem findOne(int id) throws SQLException {
		OrderItem orderItem = dao.findOne(id);
		return orderItem;
	}
	
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return dao.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
		
		return dao.findOneAndUpdate(id, orderItem);
	}
	public boolean createNew(OrderItem orderItem) throws SQLException {
		
		return dao.createNew(orderItem);
	}
}

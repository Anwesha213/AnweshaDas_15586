package com.ecommerce.order.controller;
import java.sql.SQLException;
import java.util.List;

import com.ecommerce.order.dao.OrderDao;
import com.ecommerce.order.dao.DbConnection;
import com.ecommerce.order.model.Order;
public class OrderCollection implements ICollection<Order>{

	private static OrderCollection collection;
	private OrderDao dao;
	private List<Order> orderList;
//	private BankAccountCollection() throws SQLException {
//		this.dao = BankAccountDao.getBankAccountDao();
	//  this.accountList = dao.findAll();
//	}
	private OrderCollection() {
		this.dao = OrderDao.getOrderDao();
	}
	public static OrderCollection getOrderCollection() {
		if(collection==null) {
			synchronized (OrderCollection.class) {
				if(collection==null) {
					collection = new OrderCollection();
				}
			}
		}
		return collection;
	}
	public List<Order> findAll() throws SQLException {
		orderList=dao.findAll();
		return orderList;
	}
	public Order findOne(int id) throws SQLException {
		Order orderItem = dao.findOne(id);
		return orderItem;
	}
	
	public boolean findOneAndDelete(int id) throws SQLException {
		
		return dao.findOneAndDelete(id);
	}
	public boolean findOneAndUpdate(int id, Order order) throws SQLException {
		
		return dao.findOneAndUpdate(id, order);
	}
	public boolean createNew(Order order) throws SQLException {
		
		return dao.createNew(order);
	}
}

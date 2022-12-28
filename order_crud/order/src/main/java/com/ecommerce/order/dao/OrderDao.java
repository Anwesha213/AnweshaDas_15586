package com.ecommerce.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.order.model.Order;
public class OrderDao implements IDao<Order>{
	

	private DbConnection db;
	private static OrderDao orderDao;

	private OrderDao() {
		super();	
	}

	public OrderDao(DbConnection db) {
		super();
		this.db = db;
	}
	public static OrderDao getOrderDao() {
		if(orderDao==null) {
			synchronized (OrderDao.class) {
				if(orderDao==null) {
					orderDao = new OrderDao(DbConnection.getDb());
				}
			}
		}
		return orderDao;
	}

	public List<Order> findAll() throws SQLException {
		final List<Order> list=new ArrayList<Order>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select orderId,custId,itemId,orderDate,totalOrderPrice from public.order";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new Order(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5)));			
		}
		return list;
	}

	public Order findOne(int id)  throws SQLException{
		
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select orderId,custId,itemId,orderDate,totalOrderPrice from public.order where itemId="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final Order orderItem=new Order(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getString(4),resultSet.getInt(5));
			return orderItem;
		}
		return null;
	}

	public boolean createNew(Order order)  throws SQLException{
		Connection connect=db.getConnection();		
		final String sql="insert into public.order values(?,?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, order.getOrderId());
		pStatement.setInt(2, order.getCustId());
		pStatement.setInt(3, order.getItemId());
		pStatement.setString(4, order.getOrderDate());
		pStatement.setInt(5,((int) order.getTotalOrderPrice()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from public.order where orderId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, Order order) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update public.order set orderDate=? where orderId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setString(1, order.getOrderDate());
		pStatement.setInt(2, order.getOrderId());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}

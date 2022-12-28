package com.ecommerce.orderItem.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.ecommerce.orderItem.model.OrderItem;
public class OrderItemDao implements IDao<OrderItem>{



	private DbConnection db;
	private static OrderItemDao orderItemDao;

	private OrderItemDao() {
		super();	
	}

	public OrderItemDao(DbConnection db) {
		super();
		this.db = db;
	}
	public static OrderItemDao getOrderItemDao() {
		if(orderItemDao==null) {
			synchronized (OrderItemDao.class) {
				if(orderItemDao==null) {
					orderItemDao = new OrderItemDao(DbConnection.getDb());
				}
			}
		}
		return orderItemDao;
	}

	public List<OrderItem> findAll() throws SQLException {
		final List<OrderItem> list=new ArrayList<OrderItem>();
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select itemId,pid,pname,quantity,unitPrice,itemTotalPrice from orderItem";
		ResultSet resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			list.add(new OrderItem(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6)));			
		}
		return list;
	}

	public OrderItem findOne(int id)  throws SQLException{
		
		Connection connect=db.getConnection();
		Statement statement=connect.createStatement();
		final String sql="select itemId,pid,pname,quantity,unitPrice,itemTotalPrice from orderItem where itemId="+id;
		ResultSet resultSet=statement.executeQuery(sql);
		if(resultSet.next()) {
			final OrderItem orderItem=new OrderItem(resultSet.getInt(1),resultSet.getInt(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6));
			return orderItem;
		}
		return null;
	}

	public boolean createNew(OrderItem orderItem)  throws SQLException{
		Connection connect=db.getConnection();		
		final String sql="insert into orderItem values(?,?,?,?,?,?)";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, orderItem.getItemId());
		pStatement.setInt(2, orderItem.getpid());
		pStatement.setString(3, orderItem.getpname());
		pStatement.setInt(4, orderItem.getQuantity());
		pStatement.setInt(5,((int) orderItem.getunitPrice()));
		pStatement.setInt(6,((int) orderItem.getItemTotalPrice()));
		if(pStatement.executeUpdate()>0) {
			return true;
		}
		return false;
	}

	public boolean findOneAndDelete(int id)  throws SQLException{
		final Connection connect=db.getConnection();
		final String sql="delete from orderItem where itemId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, id);
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}

	public boolean findOneAndUpdate(int id, OrderItem orderItem) throws SQLException {
		final Connection connect=db.getConnection();
		final String sql="update orderItem set quantity=? where itemId=?";
		final PreparedStatement pStatement=connect.prepareStatement(sql);
		pStatement.setInt(1, orderItem.getQuantity());
		pStatement.setInt(2, orderItem.getItemId());
		if(pStatement.executeUpdate()>0) {
			return true;
		}		
		return false;
	}
}

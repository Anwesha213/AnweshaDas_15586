package com.ecommerce.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DbConnection {


	private static DbConnection db;
	private Connection connection;

	private DbConnection() {

	}

	public static DbConnection getDb() {
		if(db==null) {
			synchronized(DbConnection.class){
				if(db==null) {
					db=new DbConnection();
				}
			}
		}
		return db;
	}

	public Connection getConnection() throws SQLException  {
		final String url="jdbc:postgresql://localhost:5432/mydb";
		final String userName="postgres";
		final String password="root"; 
		connection=DriverManager.getConnection(url,userName,password);
		return connection;
	}
}

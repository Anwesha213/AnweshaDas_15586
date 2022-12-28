package com.ecommerce.order.model;

public class Order {

	private int orderId;
	private int custId;
    private int itemId;
    private String orderDate;
    private double totalOrderPrice;
    private static int counter=2;
    
	public Order() {	
	}

	

	public Order(int custId, int itemId, String orderDate, double totalOrderPrice) {
		super();
		this.orderId = counter++;
		this.custId = custId;
		this.itemId = itemId;
		this.orderDate = orderDate;
		this.totalOrderPrice = totalOrderPrice;
	}



	public Order(int orderId, int custId, int itemId, String orderDate, double totalOrderPrice) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.itemId = itemId;
		this.orderDate = orderDate;
		this.totalOrderPrice = totalOrderPrice;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Order.counter = counter;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", custId=" + custId + ", itemId=" + itemId + ", orderDate=" + orderDate
				+ ", totalOrderPrice=" + totalOrderPrice + "]";
	}

	
	
}

package com.ecommerce.orderItem.model;

public class OrderItem {

	private int itemId;
	private int pid;
    private String pname;
    private int quantity;
    private int unitPrice;
    private int itemTotalPrice = unitPrice*quantity;
    private static int counter=3;
    
	public OrderItem() {	
	}
	public OrderItem(int pid, String pname, int quantity, int unitPrice, int itemTotalPrice) {
		super();
		this.itemId=counter++;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemTotalPrice = itemTotalPrice;	
	}
	public OrderItem(int itemId, int pid, String pname, int quantity, int unitPrice, int itemTotalPrice) {
		super();
		this.itemId = itemId;
		this.pid = pid;
		this.pname = pname;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.itemTotalPrice = itemTotalPrice;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getpid() {
		return pid;
	}
	
	public void setpid(int pid) {
		this.pid = pid;
	}
	public String getpname() {
		return pname;
	}
	public void setpname(String pname) {
		this.pname = pname;
	}
	public double getunitPrice() {
		return unitPrice;
	}
	public void setunitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getItemTotalPrice() {
		return itemTotalPrice;
	}
	public void setItemTotalPrice(int itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}
	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", pid=" + pid + ", pname=" + pname + ", quantity=" + quantity
				+ ", unitPrice=" + unitPrice + ", itemTotalPrice=" + itemTotalPrice + "]";
	}
	
}

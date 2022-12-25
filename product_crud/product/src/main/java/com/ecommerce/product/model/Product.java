package com.ecommerce.product.model;

public class Product {
    private int pid;
    private String pname;
    private double unitPrice;
    private static int counter=3;
    


	public Product() {	
	}
	public Product(String pname, double unitPrice) {
		super();
		this.pid=counter++;
		this.pname = pname;
		this.unitPrice = unitPrice;
	}
	public Product(int pid, String pname, double unitPrice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.unitPrice = unitPrice;
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
	public void setunitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", unitPrice=" + unitPrice + "]";
	}
	

}

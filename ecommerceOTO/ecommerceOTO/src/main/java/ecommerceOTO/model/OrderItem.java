package ecommerceOTO.model;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private double unitprice;
//	private Product product;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(int id, String name, String description, double unitprice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
	}
	public OrderItem(String name, String description, double unitprice) {
		super();
		this.name = name;
		this.description = description;
		this.unitprice = unitprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", name=" + name + ", description=" + description + ", unitprice=" + unitprice
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return id == other.id;
	}
	
	
	
	
	
	

}

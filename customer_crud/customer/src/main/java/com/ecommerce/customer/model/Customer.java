package com.ecommerce.customer.model;

import java.math.BigInteger;

public class Customer {

	
	    private int custId;
	    private String custName;
	    private String phone;
	    private String email;
	    private static int counter=3;
	    


		public Customer() {	
		}
		public Customer(String custName, String phone, String email) {
			super();
			this.custId=counter++;
			this.custName = custName;
			this.phone = phone;
			this.email = email;
		}
		public Customer(int custId, String custName, String phone, String email) {
			super();
			this.custId = custId;
			this.custName = custName;
			this.phone = phone;
			this.email = email;
		}
		public int getcustId() {
			return custId;
		}
		public void setcustId(int custId) {
			this.custId = custId;
		}
		public String getcustName() {
			return custName;
		}
		public void setcustName(String custName) {
			this.custName = custName;
		}
		public String getphone() {
			return phone;
		}
		public void setphone(String phone) {
			this.phone = phone;
		}
		public String getemail() {
			return email;
		}
		public void setemail(String email) {
			this.email = email;
		}
		@Override
		public String toString() {
			return "Customer [custId=" + custId + ", custName=" + custName + ", phone=" + phone + ", email=" + email
					+ "]";
		}
		

	}



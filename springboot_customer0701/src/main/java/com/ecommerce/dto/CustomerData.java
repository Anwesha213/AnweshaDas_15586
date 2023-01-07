package com.ecommerce.dto;

 

import java.util.Objects;

 

public class CustomerData {

private int custId;

private String custName;

private Long phone;

private String email;

private String permanentAddress;

public CustomerData() {

super();

// TODO Auto-generated constructor stub

}

public int getCustId() {

return custId;

}

public void setCustId(int custId) {

this.custId = custId;

}

public String getCustName() {

return custName;

}

public void setCustName(String custName) {

this.custName = custName;

}

public Long getPhone() {

return phone;

}

public void setPhone(Long phone) {

this.phone = phone;

}

public String getEmail() {

return email;

}

public void setEmail(String email) {

this.email = email;

}

public String getPermanentAddress() {

return permanentAddress;

}

public void setPermanentAddress(String permanentAddress) {

this.permanentAddress = permanentAddress;

}

 

 

 

 

 

}

 
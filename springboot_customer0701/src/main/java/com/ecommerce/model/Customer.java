package com.ecommerce.model;

 

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 

import com.ecommerce.dto.CustomerData;

 

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private int custId;
    private String custName;
    private Long phone;
    private String email;
    private String permanentAddress;
    public Customer() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Customer(int custId, String custName, Long phone, String email, String permanentAddress) {
        super();
        this.custId = custId;
        this.custName = custName;
        this.phone = phone;
        this.email = email;
        this.permanentAddress = permanentAddress;
    }
    public Customer(String custName, Long phone, String email, String permanentAddress) {
        super();
        this.custName = custName;
        this.phone = phone;
        this.email = email;
        this.permanentAddress = permanentAddress;
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
    @Override
    public int hashCode() {
        return Objects.hash(custId);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        return custId == other.custId;
    }
    @Override
    public String toString() {
        return "Customer [custId=" + custId + ", custName=" + custName + ", phone=" + phone + ", email=" + email
                + ", permanentAddress=" + permanentAddress + "]";
    }



}
package com.assignment.rewards.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CUSTOMER_ID")
    private Long customerId;
    
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    
    @Column(name = "EMAIL")
    private String email;
    
    @Column(name = "LONG_TERM_ACCESS_TOKEN")
    private String longTermAccessToken;
    
    public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLongTermAccessToken() {
		return longTermAccessToken;
	}

	public void setLongTermAccessToken(String longTermAccessToken) {
		this.longTermAccessToken = longTermAccessToken;
	}


}

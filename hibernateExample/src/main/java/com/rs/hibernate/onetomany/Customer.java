package com.rs.hibernate.onetomany;

public class Customer {
	private int customerId;
	private String customerName;
	
	private int venId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getVenId() {
		return venId;
	}
	
	public void setVenId(int venId) {
		this.venId = venId;
	}

}

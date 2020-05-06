package com.rs.hibernate.manytoone;

import java.util.Set;

public class Vendor {

	private int vendorId;
	private String vendorName;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setCustomers(Set s) {
		// TODO Auto-generated method stub

	}

}
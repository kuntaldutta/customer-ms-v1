package com.example.customer.model;

public class Customer {

	private Integer customerID;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String billInfo;

	public Customer() {

	}

	public Customer(Integer customerID, String firstName, String lastName, String address, String email,
			String billInfo) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.billInfo = billInfo;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBillInfo() {
		return billInfo;
	}

	public void setBillInfo(String billInfo) {
		this.billInfo = billInfo;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", email=" + email + ", billInfo=" + billInfo + "]";
	}

}

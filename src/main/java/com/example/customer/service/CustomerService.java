package com.example.customer.service;

import java.util.List;

import com.example.customer.model.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomer();
	public Customer saveCustomer(Customer customer);
	public Customer findCustomer(int id);
	public Customer deleteCustomer(int id);

}

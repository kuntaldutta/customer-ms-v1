package com.example.customer.service;

import java.util.List;

import com.example.customer.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public Customer save(Customer customer);

	public Customer findById(int id);

	public Customer deleteById(int id);
	
	public Customer updateById(Customer customer, int id);

}

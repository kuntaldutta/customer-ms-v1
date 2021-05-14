package com.example.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.customer.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private static List<Customer> customer = new ArrayList<>();

	static {
		customer.add(new Customer(1, "Virat", "Kohli", "Bangalore", "virat.kohli@mail.com", "Purchashed"));

	}

	@Override
	public List<Customer> getAllCustomer() {
		return customer;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

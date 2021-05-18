package com.example.customer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.customer.controller.CustomerController;
import com.example.customer.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	private static int customerCount = 3;

	static {
		customers.add(new Customer(1, "Virat", "Kohli", "Bangalore", "virat.kohli@mail.com", "Purchashed"));
		customers.add(new Customer(2, "Rahul", "Dravid", "Bangalore", "rahul.dravid@mail.com", "Purchashed"));
		customers.add(new Customer(3, "Sachin", "Tendulkar", "Bombay", "sachin.tendulkar@mail.com", "Not Purchashed"));

	}

	@Override
	public List<Customer> findAll() {
		return customers;
	}

	@Override
	public Customer save(Customer customer) {

		if (customer.getCustomerID() == null) {
			customer.setCustomerID(++customerCount);
			customers.add(customer);
		}
		return customer;
	}

	@Override
	public Customer findById(int id) {

		for (Customer customer : customers) {
			if (customer.getCustomerID() == id)
				return customer;
		}
		return null;
	}

	@Override
	public Customer deleteById(int id) {

		Iterator<Customer> itr = customers.iterator();
		while (itr.hasNext()) {
			Customer customer = itr.next();
			if (customer.getCustomerID() == id) {
				itr.remove();
				return customer;
			}
		}
		return null;
	}

}

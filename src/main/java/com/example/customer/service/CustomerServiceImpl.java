package com.example.customer.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.customer.controller.CustomerController;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.model.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

	private static List<Customer> customers = new ArrayList<>();
	private static int customerCount = 3;
	private static final String URL = "http://localhost:9999/customers/";

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

	@Override
	public Customer updateById(Customer customer, int id) {

		Customer customer1 = findById(id);
		if (customer1 == null) {
			throw new CustomerNotFoundException("id-" + id);
		}

		customer1.setCustomerID(customer.getCustomerID());
		customer1.setFirstName(customer.getFirstName());
		customer1.setLastName(customer.getLastName());
		customer1.setAddress(customer.getAddress());
		customer1.setEmail(customer.getEmail());
		customer1.setBillInfo(customer.getBillInfo());
		save(customer1);
		return customer1;
	}

	@Override
	public String findAllV2(int id) {

		RestTemplate restTemplate = new RestTemplate();
		String url = URL + id;
		Map<?, ?> mapResponse = restTemplate.getForObject(url, Map.class);
		return (String) mapResponse.get("name");
	}

	@Override
	public Map saveV2(Map customer) {

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL, customer, Map.class);
	}

	@Override
	public void updateByIdV2(Map customer, int id) {

		RestTemplate restTemplate = new RestTemplate();
		String url = URL + id;
		restTemplate.put(url, customer);
	}

}

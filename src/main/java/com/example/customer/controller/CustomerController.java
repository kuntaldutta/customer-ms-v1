package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;

	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {

		return cs.findAll();
	}

	@GetMapping("/customers/{id}")
	public Customer findCustomerById(@PathVariable int id) {

		Customer customer = cs.findById(id);
		if (customer == null) {
			throw new CustomerNotFoundException("id-" + id);
		}
		return customer;
	}

	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {

		return cs.save(customer);
	}

	@DeleteMapping("/customers/{id}")
	public Customer deleteCustomerById(@PathVariable int id) {

		return cs.deleteById(id);
	}

}

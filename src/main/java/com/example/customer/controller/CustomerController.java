package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;

	@GetMapping("/customers")
	public List<Customer> getAllCustomer() {

		return cs.getAllCustomer();
	}

}

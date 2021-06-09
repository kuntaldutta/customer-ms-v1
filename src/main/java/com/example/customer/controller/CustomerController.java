package com.example.customer.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.model.Customer;
import com.example.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService cs;

	private static final String URL = "http://localhost:9999/customers/";

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> findAllCustomers() {

		return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);

	}

	/* Getting a customer name from v2 service by id */
	@GetMapping("/customers/v2/name/{id}")
	public ResponseEntity<String> findAllCustomersV2(@PathVariable int id) {
		try {
			return new ResponseEntity<>(cs.findAllV2(id), HttpStatus.OK);

		} catch (Exception e) {
			throw new CustomerNotFoundException("id-" + id);

		}

	}

	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable int id) {

		Customer customer = cs.findById(id);
		if (customer == null) {
			throw new CustomerNotFoundException("id-" + id);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		return new ResponseEntity<>(cs.save(customer), HttpStatus.OK);
	}

	/* Adding a new customer to the v2 service */
	@PostMapping("/customers/v2")
	public ResponseEntity<Map> addCustomerv2(@RequestBody Map customer) {

		return new ResponseEntity<>(cs.saveV2(customer), HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id) {

		return new ResponseEntity<>(cs.deleteById(id), HttpStatus.OK);
	}

	@PutMapping(path = "/customers/update/{id}")
	public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable int id) {

		return new ResponseEntity<>(cs.updateById(customer, id), HttpStatus.OK);
	}

	/* Updating a customer by id in V2 service */
	@PutMapping(path = "/customers/update/v2/{id}")
	public void updateCustomerByIdV2(@RequestBody Map customer, @PathVariable int id) {

		cs.updateByIdV2(customer, id);
	}
}

package com.example.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Customer>> findAllCustomers() {

		return new ResponseEntity<>(cs.findAll(), HttpStatus.OK);

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

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable int id) {

		return new ResponseEntity<>(cs.deleteById(id), HttpStatus.OK);
	}

	@PutMapping(path = "/customers/update/{id}")
	public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer, @PathVariable int id) {

		return new ResponseEntity<>(cs.updateById(customer, id), HttpStatus.OK);
	}
}

package com.grachro.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	public CustomerRepository repository;

	@RequestMapping("/")
	public Iterable<Customer> getAll() {
		return repository.findAll();
	}
}

package com.grachro.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grachro.springboot.entity.Customer;
import com.grachro.springboot.entity.CustomerSchedule;
import com.grachro.springboot.service.CustomerService;

@RestController
public class Controller {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public CustomerScheduleRepository customerScheduleRepository;

	@Autowired
	public CustomerService customerService;

	@RequestMapping("/")
	public Iterable<Customer> getAll() {
		return customerService.setSchedule(customerRepository.findAll());
	}

	@RequestMapping("/allSchedule")
	public Iterable<CustomerSchedule> allSchedule() {
		return customerScheduleRepository.findAll();
	}
}

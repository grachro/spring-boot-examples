package com.grachro.springboot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grachro.springboot.entity.Customer;
import com.grachro.springboot.entity.CustomerSchedule;
import com.grachro.springboot.service.CustomerService;

@RestController
@Scope(value = "session")
public class Controller {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public CustomerScheduleRepository customerScheduleRepository;

	@Autowired
	public CustomerService customerService;

	@PersistenceContext
	public EntityManager em;

	@RequestMapping("/")
	public Iterable<Customer> getAll() {

		System.out.println("==Application.em==");
		System.out.println(Application.getEntityManager());
		System.out.println("==em==");
		System.out.println(em);
		System.out.println("==customerService==");
		System.out.println(customerService);
		System.out.println("======");
		return customerService.setSchedule(customerRepository.findAll());
	}

	@RequestMapping("/allSchedule")
	public Iterable<CustomerSchedule> allSchedule() {
		return customerScheduleRepository.findAll();
	}
}

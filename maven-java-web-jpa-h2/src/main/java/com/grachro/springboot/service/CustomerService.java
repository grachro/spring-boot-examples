package com.grachro.springboot.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grachro.springboot.CustomerRepository;
import com.grachro.springboot.CustomerScheduleRepository;
import com.grachro.springboot.entity.Customer;
import com.grachro.springboot.entity.CustomerSchedule;

@Component
public class CustomerService {

	@Autowired
	public CustomerRepository customerRepository;

	@Autowired
	public CustomerScheduleRepository customerScheduleRepository;

	@Autowired
	public EntityManager em;

	@Override
	public String toString() {
		return "em=" + this.em + ",customerRepository=" + this.customerRepository;
	}

	public Customer setSchedule(Customer customer) {
		List<CustomerSchedule> list = this.customerScheduleRepository.findByCustomerId(customer.getCustomerId());
		customer.setCustomerSchedules(list);
		return customer;
	}
	
	public Iterable<Customer> setSchedule(Iterable<Customer> customers) { 
		for (Customer customer:customers) {
			this.setSchedule(customer);
		}
		
		return customers;
	}
}

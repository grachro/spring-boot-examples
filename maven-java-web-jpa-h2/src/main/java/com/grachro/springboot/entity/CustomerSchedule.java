package com.grachro.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerSchedulerId;

	private String title;

	private long customerId;

	public CustomerSchedule() {
	}

	public CustomerSchedule(String title, Customer customer) {
		this.title = title;
		this.customerId = customer.getCustomerId();
	}

	@Override
	public String toString() {
		return String.format("Customer[title=%s, customerId='%d']", title, customerId);
	}

	public long getCustomerSchedulerId() {
		return customerSchedulerId;
	}

	public void setCustomerSchedulerId(long customerSchedulerId) {
		this.customerSchedulerId = customerSchedulerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

}

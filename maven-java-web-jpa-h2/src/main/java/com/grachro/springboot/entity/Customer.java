package com.grachro.springboot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String firstName;
	private String lastName;

	@Transient
	private List<CustomerSchedule> _customerSchedules;

	protected Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Customer[customerId=%d, firstName='%s', lastName='%s']", customerId, firstName, lastName);
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<CustomerSchedule> getCustomerSchedules() {
		return this._customerSchedules;
	}

	public void setCustomerSchedules(List<CustomerSchedule> customerSchedules) {
		this._customerSchedules = customerSchedules;
	}
}
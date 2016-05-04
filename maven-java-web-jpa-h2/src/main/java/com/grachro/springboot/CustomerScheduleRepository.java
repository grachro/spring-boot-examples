package com.grachro.springboot;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grachro.springboot.entity.CustomerSchedule;

public interface CustomerScheduleRepository extends CrudRepository<CustomerSchedule, Long> {
	List<CustomerSchedule> findByCustomerId(long customerId);
}
package com.grachro.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grachro.springboot.entity.Customer;
import com.grachro.springboot.entity.CustomerSchedule;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

 
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository customerR, CustomerScheduleRepository customerScheduleR) {
		return (args) -> {
			// save a couple of customers
			log.info("save Customers");
			customerR.save(new Customer("Jack", "Bauer"));
			customerR.save(new Customer("Chloe", "O'Brian"));
			customerR.save(new Customer("Kim", "Bauer"));
			customerR.save(new Customer("David", "Palmer"));
			customerR.save(new Customer("Michelle", "Dessler"));

			log.info("save CustomerSchedule");
			Customer bauer = customerR.findByLastName("Bauer").get(0);
			customerScheduleR.save(new CustomerSchedule("外出", bauer));
			customerScheduleR.save(new CustomerSchedule("食事", bauer));

			Customer oBrian = customerR.findByLastName("O'Brian").get(0);
			customerScheduleR.save(new CustomerSchedule("休暇", oBrian));

			log.info("CustomerSchedule found with findByCustomerId(customerId):");
			log.info("--------------------------------------------");
			for (CustomerSchedule schedule : customerScheduleR.findByCustomerId(bauer.getCustomerId())) {
				log.info("Bauer::" + schedule.toString());
			}
			for (CustomerSchedule schedule : customerScheduleR.findByCustomerId(oBrian.getCustomerId())) {
				log.info("O'Brian::" + schedule.toString());
			}

			Customer bauer2 = customerR.findByLastName("Bauer").get(0);
			bauer2.getCustomerSchedules();
		};
	}

}
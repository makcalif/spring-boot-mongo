package com;

import com.spark.arabic.collection.Senators;
import com.spark.arabic.config.CustomUserDetails;
import com.spark.arabic.entities.Role;
import com.spark.arabic.entities.User;
import com.spark.arabic.repository.SenatorsRepository;
import com.spark.arabic.repository.UserRepository;
import hello.Customer;
import hello.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
		//(scanBasePackages = "com.spark.arabic.repository")
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.spark.arabic.repository")

public class Application implements CommandLineRunner {

	//@Autowired
	private CustomerRepository repository;

	@Autowired
	private SenatorsRepository senatorsRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository repo) throws Exception {
		if(repo.count() == 0)
			repo.save(new User("user", "user", Arrays.asList( new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(username -> new CustomUserDetails(repo.findByUsername(username)));
	}

	@Override
	public void run(String... args) throws Exception {

		List<Senators> senatorsList = senatorsRepository.findAll();
		List<Senators> names = senatorsRepository.findByPersonFirstname("Tina");
		System.out.println(senatorsList);

//		List<Customer> cust = repository.findAll();
//		System.out.println(cust);


		//repository.save(new Customer("Mumtaz", "Khan"));

		/*
		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		*/
	}

}

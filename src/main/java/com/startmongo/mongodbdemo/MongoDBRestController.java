package com.startmongo.mongodbdemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoDBRestController {
	@Autowired
	CustomerRepository customerRepository;
	@RequestMapping(value="/customers", method=RequestMethod.GET)
public List<Customer>getCustomers(){
		return customerRepository.findAll();
	}
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public String createCustomers(@RequestBody Customer customer){
		customerRepository.save(customer);	
		return "Customer is created successfully";
		}
}

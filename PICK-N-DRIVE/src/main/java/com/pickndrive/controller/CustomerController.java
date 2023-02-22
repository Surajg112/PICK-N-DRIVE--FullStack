package com.pickndrive.controller;

import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pickndrive.entities.Customer;
import com.pickndrive.models.CustomerDTO;
import com.pickndrive.models.LoginDTO;
import com.pickndrive.services.CustomerService;
import com.pickndrive.services.EmailService;

@CrossOrigin
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmailService emailService;
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody CustomerDTO customerDto) throws MessagingException{
		if(customerService.verifyUserId(customerDto.getUserid())) {
			return ResponseEntity.badRequest().body("Email already registered");
		}
		Customer result=customerService.registerCustomer(customerDto);
		String str;
		if(result!=null)
			{str=result.getUserid();
			emailService.sendSimpleEmail(str, "You have registered successfully!\n Email = "+str+"\n Password = "+result.getPwd(),"Welcome To Pick-N-Drive.com services!!");
			return ResponseEntity.ok("Customer registered successfully");
		}else
			{
			return ResponseEntity.badRequest().body("Email already registered");
			}
	}
	
	@GetMapping
	public ResponseEntity<?> findAllCustomers() {
		List<Customer> result = customerService.allCustomers();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@Valid @RequestBody LoginDTO dto) {
		System.out.println(dto);
		Customer user=customerService.validate(dto.getUserid(),dto.getPwd());
		if(user!=null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProfile(@Valid @RequestBody CustomerDTO customerDto,@PathVariable Customer cust) {
		customerService.updateProfile(customerDto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

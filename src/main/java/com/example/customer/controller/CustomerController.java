package com.example.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerIdNotFoundException;
import com.example.customer.exception.CustomerNameNotFoundException;
import com.example.customer.exception.CustomerNotFoundByEmailIdException;
import com.example.customer.exception.CustomerNotFoundByGenderException;
import com.example.customer.exception.CustomerNotFoundByPhoneNumberException;
import com.example.customer.exception.CustomerNotFoundByPuchaseValueException;
import com.example.customer.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	CustomerService custSer;

	@PostMapping(value = "/add")
	public String addCustomer(@RequestBody Customer cus) {
		return custSer.addCustomer(cus);
	}

	@GetMapping(value = "/get/{id}")
	public Customer getCustomer(@PathVariable int id) throws CustomerIdNotFoundException {
		return custSer.getCustomer(id);
	}

	@PutMapping(value = "update/{id}")
	public String updateCustomer(@RequestBody Customer id) {
		return custSer.updateCustomer(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteCustomer(@PathVariable int id) {
		return custSer.deleteCustomer(id);
	}

	@PostMapping(value = "/addAll")
	public String addCustomers(@RequestBody List<Customer> cus) {
		return custSer.addCustomers(cus);
	}

	@GetMapping(value = "/getAll")
	public List<Customer> getCustomers() {
		return custSer.getCustomers();
	}

	@GetMapping(value = "/getByName/{name}")
	public List<Customer> getByname(@PathVariable String name) throws CustomerNameNotFoundException {
		return custSer.getByName(name);
	}

	@GetMapping(value = "/getByPurchaseValue/{pvalue}")
	public List<Customer> getByPurchaseValue(@PathVariable int pvalue) throws CustomerNotFoundByPuchaseValueException {
		return custSer.getByPurchaseValue(pvalue);
	}

	@GetMapping(value = "/getByGender/{gender}")
	public List<Customer> getByGender(String gender) throws CustomerNotFoundByGenderException {
		return custSer.getByGender(gender);
	}

	@GetMapping(value = "/getByMailId/{mail}")
	public List<Customer> getByMailId(@PathVariable String mail) throws CustomerNotFoundByEmailIdException {
		return custSer.getByMailId(mail);
	}

	@GetMapping(value = "/getByPhoneNumber/{phno}")
	public List<Customer> getByPhoneNumber(@PathVariable long phno) throws CustomerNotFoundByPhoneNumberException {
		return custSer.getByPhoneNumber(phno);
	}

	@GetMapping(value = "/getByAbovePurchaseValue/{pvalue}")
	public List<Customer> getByAbovePurchaseValue(@PathVariable int pvalue)
			throws CustomerNotFoundByPuchaseValueException {
		return custSer.getByAbovePurchaseValue(pvalue);
	}

	@GetMapping(value = "/getGenderBetweenPurchaseValue/{value1}/{value2}")
	public List<String> getGenderBetweenPurchaseValue(@PathVariable int value1, @PathVariable int value2)
			throws CustomerNotFoundByPuchaseValueException {
		return custSer.getGenderBetweenPurchaseValue(value1, value2);
	}

	@GetMapping(value = "/getPhoneNumberUsingMail/{mail}")
	public List<Long> getPhoneNumberUsingMail(@PathVariable String mail) throws CustomerNotFoundByEmailIdException {
		return custSer.getPhoneNumberUsingMail(mail);
	}

}

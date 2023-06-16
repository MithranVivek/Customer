package com.example.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.customer.entity.Bank;
import com.example.customer.entity.BankCustomer;
import com.example.customer.exception.BankCoustomerBranchNotFoundException;
import com.example.customer.exception.CustomerIdNotFoundException;
import com.example.customer.service.BankCustomerService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/bankcustomer")
@CrossOrigin(origins = "http://localhost:8085")
@Endpoint(id = "getBankCustomers")
public class BankCustomerController {

	@Autowired
	BankCustomerService bankSer;

	@Autowired
	RestTemplate rest;
	
	@Autowired
	WebClient.Builder webClient;

	@PostMapping(value = "/add")
	public String addBankCustomer(@RequestBody BankCustomer bankCustomer) throws Exception {

		String url = "http://localhost:8081/bank/getIfscCodeByBranch/";
		String url1 = "http://localhost:8081/bank/getAll";

//		ResponseEntity<List<Bank>> ex0 = rest.exchange(url1, HttpMethod.GET, null,
//				new ParameterizedTypeReference<List<Bank>>() {
//				});
//		List<Bank> allBank = ex0.getBody();
		
		List<Bank> allBank = webClient.build().get().uri(url1).retrieve().bodyToFlux(Bank.class).collectList().block();
		
		boolean branch = true;
		for (Bank b : allBank) {
			if (b.getBranch().equalsIgnoreCase(bankCustomer.getBranch())) {
				branch = false;
			}
		}

		if (branch == true) {
			throw BankCoustomerBranchNotFoundException();
		} else {

//			ResponseEntity<String> ex1 = rest.exchange(url + bankCustomer.getBranch(), HttpMethod.GET, null,
//					String.class);
//			String ifsc = ex1.getBody();
			
			String ifsc = webClient.build().get().uri(url+ bankCustomer.getBranch()).retrieve().bodyToMono(String.class).block();

			bankCustomer.setIfscCode(ifsc);
			return bankSer.addBankCustomer(bankCustomer);
		}
	}
	
	@Bean
	private Exception BankCoustomerBranchNotFoundException() {
		return new BankCoustomerBranchNotFoundException();
	}

	@GetMapping(value = "/get/{id}")
	public BankCustomer getBankCustomer(@PathVariable int id) throws Exception {
		String url1 = "http://localhost:8081/bank/getAll";

		ResponseEntity<List<Bank>> ex0 = rest.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Bank>>() {
				});
		List<Bank> allBank = ex0.getBody();
		boolean cid = true;
		for(Bank x : allBank) {
		if(x.getId() == id) {
			cid = false;
		}
		}
		if(cid == true) {
		throw CustomerIdNotFoundException();
		} else {
		return bankSer.getBankCustomer(id);
		}
	}
	@Bean
	private Exception CustomerIdNotFoundException() {
		return new CustomerIdNotFoundException();
	}

	@PutMapping(value = "/update/{id}")
	public String updateBankCustomer(@RequestBody BankCustomer id) throws BankCoustomerBranchNotFoundException {
		String url = "http://localhost:8081/bank/getIfscCodeByBranch/";
		String url1 = "http://localhost:8081/bank/getAll";

		ResponseEntity<List<Bank>> ex0 = rest.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Bank>>() {
				});
		List<Bank> allBank = ex0.getBody();
		boolean branch = true;
		for (Bank b : allBank) {
			if (b.getBranch().equalsIgnoreCase(id.getBranch())) {
				branch = false;
			}
		}

		if (branch == true) {
			throw new BankCoustomerBranchNotFoundException();
		} else {

			ResponseEntity<String> ex1 = rest.exchange(url + id.getBranch(), HttpMethod.GET, null, String.class);
			String ifsc = ex1.getBody();
			id.setIfscCode(ifsc);
			return bankSer.updateBankCustomer(id);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteBankCustomer(@PathVariable int id) {
		return bankSer.deleteBankCustomer(id);
	}

	@PostMapping(value = "/addAll")
	public String addBankCustomers(@RequestBody List<BankCustomer> bankCustomer)
			throws BankCoustomerBranchNotFoundException {
		String url = "http://localhost:8081/bank/getIfscCodeByBranch/";
		List<BankCustomer> bc = bankCustomer;

		String url1 = "http://localhost:8081/bank/getAll";

		ResponseEntity<List<Bank>> ex0 = rest.exchange(url1, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Bank>>() {
				});
		List<Bank> allBank = ex0.getBody();
		
		for (Bank b : allBank) {
			for (int i = 0; i < bankCustomer.size(); i++) {
				if (b.getBranch().equalsIgnoreCase(bankCustomer.get(i).getBranch())) {
					throw new BankCoustomerBranchNotFoundException();
				} else {
					for (BankCustomer c : bc) {
						ResponseEntity<String> ex1 = rest.exchange(url + c.getBranch(), HttpMethod.GET, null,
								String.class);
						String ifsc = ex1.getBody();
						c.setIfscCode(ifsc);
					}
				}
			}
		}
		return bankSer.addBankCustomers(bc);

	}

	@GetMapping(value = "/getAll")
	@ReadOperation
	public List<BankCustomer> getBankCustomers() {
		return bankSer.getBankCustomers();
	}

}

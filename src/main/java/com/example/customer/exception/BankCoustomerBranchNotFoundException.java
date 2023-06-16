package com.example.customer.exception;

import org.springframework.context.annotation.Bean;

public class BankCoustomerBranchNotFoundException extends Exception{

	public BankCoustomerBranchNotFoundException() {
			super();
	}
	
	@Bean
	BankCoustomerBranchNotFoundException branchNotFound() {
		return new BankCoustomerBranchNotFoundException();
	}

}

package com.example.customer.exceptionHandle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.customer.exception.BankCoustomerBranchNotFoundException;
import com.example.customer.exception.CustomerIdNotFoundException;
import com.example.customer.exception.CustomerNameNotFoundException;
import com.example.customer.exception.CustomerNotFoundByEmailIdException;
import com.example.customer.exception.CustomerNotFoundByGenderException;
import com.example.customer.exception.CustomerNotFoundByPhoneNumberException;
import com.example.customer.exception.CustomerNotFoundByPuchaseValueException;

@RestControllerAdvice
public class CustomerExceptions {
	
	@ExceptionHandler(CustomerNameNotFoundException.class)
	public ResponseEntity<Object> nameNotFound() {
		return new ResponseEntity<>("No Data in this Name", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerIdNotFoundException.class)
	public ResponseEntity<Object> idNotFound() {
		return new ResponseEntity<>("No Data in this ID", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundByEmailIdException.class)
	public ResponseEntity<Object> mailIdNotFound() {
		return new ResponseEntity<>("No Data in this MailId", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundByGenderException.class)
	public ResponseEntity<Object> genderNotFound() {
		return new ResponseEntity<>("No Data in this Gender", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundByPhoneNumberException.class)
	public ResponseEntity<Object> phoneNoNotFound() {
		return new ResponseEntity<>("No Data in this PhoneNumber", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CustomerNotFoundByPuchaseValueException.class)
	public ResponseEntity<Object> purchaseValueNotFound() {
		return new ResponseEntity<>("No Data in this Purchase Value", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BankCoustomerBranchNotFoundException.class)
	public ResponseEntity<Object> branchNotFound() {
		return new ResponseEntity<>("Branch Name Enterd Wrong Please Check", HttpStatus.NOT_FOUND);
	}

}

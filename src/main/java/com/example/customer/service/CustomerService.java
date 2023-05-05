package com.example.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dao.CustomerDao;
import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerIdNotFoundException;
import com.example.customer.exception.CustomerNameNotFoundException;
import com.example.customer.exception.CustomerNotFoundByEmailIdException;
import com.example.customer.exception.CustomerNotFoundByGenderException;
import com.example.customer.exception.CustomerNotFoundByPhoneNumberException;
import com.example.customer.exception.CustomerNotFoundByPuchaseValueException;

@Service
public class CustomerService {

	@Autowired
	CustomerDao custDao;

	public String addCustomer(Customer cus) {
		
			return custDao.addCustomer(cus);
		
	}

	public Customer getCustomer(int id) throws CustomerIdNotFoundException {
		return custDao.getCustomer(id);
	}

	public String updateCustomer(Customer id) {
		return custDao.updateCustomer(id);
	}

	public String deleteCustomer(int id) {
		return custDao.deleteCustomer(id);
	}

	public String addCustomers(List<Customer> cus) {
		return custDao.addCustomers(cus);
	}

	public List<Customer> getCustomers() {
		return custDao.getCustomers();
	}

	public List<Customer> getByName(String name) throws CustomerNameNotFoundException {
		if (custDao.getByName(name).isEmpty()) {
			throw new CustomerNameNotFoundException("Given Name is not available");
		} else {
			return custDao.getByName(name);
		}
	}

	public List<Customer> getByPurchaseValue(int pvalue) throws CustomerNotFoundByPuchaseValueException {
		if (custDao.getByPurchaseValue(pvalue).isEmpty()) {
			throw new CustomerNotFoundByPuchaseValueException();
		} else {
			return custDao.getByPurchaseValue(pvalue);
		}
	}

	public List<Customer> getByGender(String gender) throws CustomerNotFoundByGenderException {
		if (custDao.getByGender(gender).isEmpty()) {
			throw new CustomerNotFoundByGenderException();
		} else {
			return custDao.getByGender(gender);
		}
	}

	public List<Customer> getByMailId(String mail) throws CustomerNotFoundByEmailIdException {
		if (custDao.getByMailId(mail).isEmpty()) {
			throw new CustomerNotFoundByEmailIdException();
		} else {
			return custDao.getByMailId(mail);
		}
	}

	public List<Customer> getByPhoneNumber(long phno) throws CustomerNotFoundByPhoneNumberException {
		if (custDao.getByPhoneNumber(phno).isEmpty()) {
			throw new CustomerNotFoundByPhoneNumberException();
		} else {
			return custDao.getByPhoneNumber(phno);
		}
	}

	public List<Customer> getByAbovePurchaseValue(int pvalue) throws CustomerNotFoundByPuchaseValueException {
		if (custDao.getByPurchaseValue(pvalue).isEmpty()) {
			throw new CustomerNotFoundByPuchaseValueException();
		} else {
			return custDao.getByAbovePurchaseValue(pvalue);
		}
	}

	public List<String> getGenderBetweenPurchaseValue(int value1, int value2)
			throws CustomerNotFoundByPuchaseValueException {
		if (custDao.getGenderBetweenPurchaseValue(value1, value2).isEmpty()) {
			throw new CustomerNotFoundByPuchaseValueException();
		} else {
			return custDao.getGenderBetweenPurchaseValue(value1, value2);
		}
	}

	public List<Long> getPhoneNumberUsingMail(String mail) throws CustomerNotFoundByEmailIdException {
		if (custDao.getPhoneNumberUsingMail(mail).isEmpty()) {
			throw new CustomerNotFoundByEmailIdException();
		} else {
			return custDao.getPhoneNumberUsingMail(mail);
		}
	}

}

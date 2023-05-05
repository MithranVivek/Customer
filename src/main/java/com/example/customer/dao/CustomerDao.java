package com.example.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.Customer;
import com.example.customer.exception.CustomerIdNotFoundException;

import com.example.customer.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepository custRepo;

	public String addCustomer(Customer cus) {
		custRepo.save(cus);
		return "Customer Details Successfully added";
	}

	public Customer getCustomer(int id) throws CustomerIdNotFoundException {
		return custRepo.findById(id).orElseThrow(() -> new CustomerIdNotFoundException());
	}

	public String updateCustomer(Customer id) {
		custRepo.save(id);
		return "Customer Details Updated Successfully";
	}

	public String deleteCustomer(int id) {
		custRepo.deleteById(id);
		return "Customer Details Successfully Deleted";
	}

	public String addCustomers(List<Customer> cus) {
		custRepo.saveAll(cus);
		return "Successfully added List";
	}

	public List<Customer> getCustomers() {
		return custRepo.findAll();

	}

	public List<Customer> getByName(String name) {
		return custRepo.getByName(name);

	}

	public List<Customer> getByPurchaseValue(int pvalue) {

		return custRepo.getByPurchaseValue(pvalue);

	}

	public List<Customer> getByGender(String gender) {

		return custRepo.getByGender(gender);
	}

	public List<Customer> getByMailId(String mail) {

		return custRepo.getByMailId(mail);
	}

	public List<Customer> getByPhoneNumber(long phno) {

		return custRepo.getByPhoneNumber(phno);
	}

	public List<Customer> getByAbovePurchaseValue(int pvalue) {
		return custRepo.getByAbovePurchaseValue(pvalue);
	}

	public List<String> getGenderBetweenPurchaseValue(int value1, int value2) {
		return custRepo.getGenderBetweenPurchaseValue(value1, value2);
	}

	public List<Long> getPhoneNumberUsingMail(String mail) {
		return custRepo.getPhoneNumberUsingMail(mail);
	}

}

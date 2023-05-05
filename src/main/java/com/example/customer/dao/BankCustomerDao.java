package com.example.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.customer.entity.BankCustomer;
import com.example.customer.repository.BankCustomerRepository;


@Repository
public class BankCustomerDao {
	
	@Autowired
	BankCustomerRepository bankRepo;

	public String addBankCustomer(BankCustomer bank) {
		bankRepo.save(bank);
		return "successfully Saved";
	}

	public BankCustomer getBankCustomer(int id) {
		return bankRepo.findById(id).get();

	}

	public String updateBankCustomer(BankCustomer id) {
		bankRepo.save(id);
		return "successfully updated";
	}

	public String deleteBankCustomer(int id) {
		bankRepo.deleteById(id);
		return "successfully Deleted";
	}

	public String addBankCustomers(List<BankCustomer> bank) {
		bankRepo.saveAll(bank);
		return "Successfully Saved";
	}

	public List<BankCustomer> getBankCustomers() {
		return bankRepo.findAll();
	}

}

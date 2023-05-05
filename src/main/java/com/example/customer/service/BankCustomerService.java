package com.example.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.customer.dao.BankCustomerDao;
import com.example.customer.entity.BankCustomer;


@Service
public class BankCustomerService {
	
	@Autowired
	BankCustomerDao bankDao;

	public String addBankCustomer(BankCustomer bank) {
		return bankDao.addBankCustomer(bank);
	}

	public BankCustomer getBankCustomer(int id) {
		return bankDao.getBankCustomer(id);
	}

	public String updateBankCustomer(BankCustomer id) {
		return bankDao.updateBankCustomer(id);
	}

	public String deleteBankCustomer(int id) {
		return bankDao.deleteBankCustomer(id);
	}

	public String addBankCustomers(List<BankCustomer> bank) {
		return bankDao.addBankCustomers(bank);
	}

	public List<BankCustomer> getBankCustomers() {
		return bankDao.getBankCustomers();
	}

	

}

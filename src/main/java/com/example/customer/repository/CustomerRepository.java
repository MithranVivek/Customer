package com.example.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query(value = "select * from customers where name = ?",nativeQuery = true)
	public List<Customer> getByName(String name);
	
	@Query(value = "select * from customers where purchase_value = ?", nativeQuery = true)
	public List<Customer> getByPurchaseValue(int pvalue);
	
	@Query(value = "select * from customers where gender = ?", nativeQuery = true)
	public List<Customer> getByGender(String gender);
	
	@Query(value = "select * from customers where mail_id = ?", nativeQuery = true)
	public List<Customer> getByMailId(String mail);
	
	@Query(value = "select * from customers where phone_number = ?", nativeQuery = true)
	public List<Customer> getByPhoneNumber(long phno);
	
	@Query(value = "select * from customers where purchase_value > ?", nativeQuery = true)
	public List<Customer> getByAbovePurchaseValue(int pvalue);
	
	@Query(value = "select gender from customers where purchase_value >= ? and purchase_value <= ?", nativeQuery = true)
	public List<String> getGenderBetweenPurchaseValue(int value1, int value2);
	
	@Query(value = "select phone_number from customers where mail_id like %?% ", nativeQuery = true)
	public List<Long> getPhoneNumberUsingMail(String mail);

}

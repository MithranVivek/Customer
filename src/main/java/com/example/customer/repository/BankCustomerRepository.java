package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.BankCustomer;

public interface BankCustomerRepository extends JpaRepository<BankCustomer, Integer> {

}

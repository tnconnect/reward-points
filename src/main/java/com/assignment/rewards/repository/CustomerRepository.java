package com.assignment.rewards.repository;

import org.springframework.data.repository.CrudRepository;

import com.assignment.rewards.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
    public Customer findByCustomerId(Long customerId);
    public Customer findByCustomerName(String customerName);
}

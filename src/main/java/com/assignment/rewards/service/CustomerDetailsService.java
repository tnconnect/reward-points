package com.assignment.rewards.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assignment.rewards.entity.Customer;
import com.assignment.rewards.repository.CustomerRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepository.findByCustomerName(username);
		return new org.springframework.security.core.userdetails.User(customer.getCustomerName(),
				customer.getLongTermAccessToken(), new ArrayList<>());
	}
}

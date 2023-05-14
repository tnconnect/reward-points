package com.assignment.rewards.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rewards.entity.Customer;
import com.assignment.rewards.model.RewardPoints;
import com.assignment.rewards.repository.CustomerRepository;
import com.assignment.rewards.service.RewardPointsService;

@RestController
@RequestMapping("/rewards")
public class RewardPointsController {

	@Autowired
	RewardPointsService rewardsService;

	@Autowired
	CustomerRepository customerRepository;

	Logger logger = LoggerFactory.getLogger(RewardPointsController.class);

	@GetMapping(value = "/v1/{customerId}/{fromDate}/{toDate}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RewardPoints> getRewardPointsByCustomerId(@PathVariable("customerId") Long customerId,
			@PathVariable("fromDate") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate fromDate,
			@PathVariable("toDate") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate toDate) {
		
		validatePathParam(customerId, fromDate, toDate);
		Customer customer = customerRepository.findByCustomerId(customerId);
		if (customer == null) {
			throw new RuntimeException("Missing customer Id ");
		}
		RewardPoints customerRewards = rewardsService.getRewardsByFromDateToDate(customerId, fromDate, toDate);
		return new ResponseEntity<>(customerRewards, HttpStatus.OK);
	}

	private void validatePathParam(Long customerId, LocalDate fromDate, LocalDate toDate) {
		logger.info(String.valueOf(fromDate) +" : "+String.valueOf(toDate));
		if (customerId == null || customerId <= 0) {
			throw new RuntimeException("Invalid customer Id ");
		}
		if (toDate == null || fromDate == null || toDate.isBefore(fromDate)) {
			throw new RuntimeException(
					"Invalid Dates: Date should be like \"MM-dd-yyyy\" and from date should be less than to date");
		}

	}

}

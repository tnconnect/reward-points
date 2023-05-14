package com.assignment.rewards.service;

import java.time.LocalDate;

import com.assignment.rewards.model.RewardPoints;

public interface RewardPointsService {
	public RewardPoints getRewardsByFromDateToDate(Long customerId, LocalDate fromDate, LocalDate todate);
}

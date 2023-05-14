package com.assignment.rewards.model;

import java.time.LocalDate;

public class RewardPointDetails {
	
	LocalDate startDate;
	LocalDate endDate;
	long rewardPoints;
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public long getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}

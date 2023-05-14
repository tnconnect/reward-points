package com.assignment.rewards.model;

import java.util.List;

public class RewardPoints {
	private long customerId;
	private long totalRewards;
	private List<RewardPointDetails> rewardDetailList;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}

	public List<RewardPointDetails> getRewardDetailList() {
		return rewardDetailList;
	}

	public void setRewardDetailList(List<RewardPointDetails> rewardDetailList) {
		this.rewardDetailList = rewardDetailList;
	}
}

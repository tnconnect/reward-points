package com.assignment.rewards.service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.rewards.entity.Transaction;
import com.assignment.rewards.model.RewardPointDetails;
import com.assignment.rewards.model.RewardPoints;
import com.assignment.rewards.repository.TransactionRepository;

/**
 * @author tarak
 *
 */
@Service
public class RewardPointsServiceImpl implements RewardPointsService {

	
	@Autowired
	TransactionRepository transactionRepository;
	
	Logger logger = LoggerFactory.getLogger(RewardPointsServiceImpl.class);
	 
	public static int firstRewardLimit = 50;
    public static int secondRewardLimit = 100; 
	
	private LocalDate getEndOfMonth(YearMonth yearMonth) {
		return yearMonth.atEndOfMonth();
	}
	
	private LocalDate getFirstOfMonth(YearMonth yearMonth) {
		return yearMonth.atDay( 1 );
	}
	
	/**
	 * @param fromDate
	 * @param toDate
	 * @return
	 */
	private List<LocalDate[] > getListOfMonthlyDates(LocalDate fromDate, LocalDate toDate ){
		
		int fromYear = fromDate.getYear();
		int fromMonth = fromDate.getMonthValue();
		YearMonth fromYearMonth = YearMonth.of( fromYear, fromMonth );     // 2015-01. January of 2015.
		YearMonth tempYearMonth = YearMonth.of( fromYear, fromMonth );
				
		int toYear = toDate.getYear();
		int toMonth = toDate.getMonthValue();
		YearMonth toYearMonth = YearMonth.of( toYear, toMonth ); 
		
		List<LocalDate[] > monthlyPurchaseList = new ArrayList<LocalDate[]>();
		if(fromYearMonth.equals(toYearMonth)) {
			monthlyPurchaseList.add(new LocalDate[]{fromDate,toDate});
		}else {
			int i = 1;
			while(tempYearMonth.isBefore(toYearMonth) ) {
				if(i==1) {
					monthlyPurchaseList.add(new LocalDate[]{fromDate,getEndOfMonth(fromYearMonth)});
				}else {
					monthlyPurchaseList.add(new LocalDate[]{getFirstOfMonth(tempYearMonth),getEndOfMonth(tempYearMonth)});
				}
				i++;
				tempYearMonth = tempYearMonth.plusMonths(1);
			}
			monthlyPurchaseList.add(new LocalDate[]{getFirstOfMonth(toYearMonth),toDate});
			
		}
		
		return monthlyPurchaseList;
		
	}
	
	@Override
	public RewardPoints getRewardsByFromDateToDate(Long customerId, LocalDate fromDate, LocalDate toDate) {
		
		List<LocalDate[] > monthlyDateList = getListOfMonthlyDates(fromDate,toDate);
		LocalDate[] monthlyDates;
		long totalPoints = 0;
		RewardPointDetails rewardDetails ;
		long monthlyRewards = 0;
		List<RewardPointDetails> rewardDetailList = new ArrayList<RewardPointDetails>();
		for (int i = 0; i < monthlyDateList.size(); i++) {
			monthlyDates = monthlyDateList.get(i);
			List<Transaction> monthlyTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
					customerId, monthlyDates[0].atStartOfDay(), monthlyDates[1].atStartOfDay());
			
			monthlyRewards = getRewardPointsPerMonth(monthlyTransactions);
			totalPoints = totalPoints + monthlyRewards;
			
			rewardDetails = new RewardPointDetails();
			rewardDetails.setStartDate(monthlyDates[0]);
			rewardDetails.setEndDate(monthlyDates[1]);
			rewardDetails.setRewardPoints(monthlyRewards);
			rewardDetailList.add(rewardDetails);
		}
		
		RewardPoints customerRewards = new RewardPoints();
		customerRewards.setCustomerId(customerId);
		customerRewards.setTotalRewards(totalPoints);
		customerRewards.setRewardDetailList(rewardDetailList);
		
		return customerRewards;
		
	}
	
	private Long getRewardPointsPerMonth(List<Transaction> transactions) {
		return transactions.stream().map(transaction -> calculateRewardPoints(transaction))
				.collect(Collectors.summingLong(r -> r.longValue()));
	}

	private Long calculateRewardPoints(Transaction t) {
		if (t.getTransactionAmount() > firstRewardLimit && t.getTransactionAmount() <= secondRewardLimit) {
			return Math.round(t.getTransactionAmount() - firstRewardLimit);
		} else if (t.getTransactionAmount() > secondRewardLimit) {
			return Math.round(t.getTransactionAmount() - secondRewardLimit) * 2
					+ (secondRewardLimit - firstRewardLimit);
		} else
			return 0l;

	}

}

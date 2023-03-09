package com.kusumika.school.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kusumika.school.bean.Fees;
import com.kusumika.school.bean.FeesCollection;
import com.kusumika.school.bean.FeesDue;
import com.kusumika.school.mapper.kusumikadb.FeesMapper;
import com.kusumika.school.service.FeesService;

@Component
public class FeesServiceImpl implements FeesService {

	@Autowired
	FeesMapper feesMapper;
	
	@Override
	public FeesDue getFeesDue(int householdId) {
		List<Fees> feesScale = feesMapper.getTotalFees(householdId);
		FeesCollection feesCollection = feesMapper.getFeesCollectionReport(householdId);

		Integer monthDue = getMonthDue(feesScale, feesCollection);
		Integer totalDue = getTotalDue(feesScale, feesCollection);

		FeesDue feesDue = new FeesDue(monthDue, totalDue);
		return feesDue;
	}

	private Integer getMonthDue(List<Fees> feesScale, FeesCollection feesCollection) {
		Integer monthFees = 0, monthDue = 0;
		int currentMonth = LocalDate.now().getMonthValue();
		
		for (Fees fees : feesScale) {
			monthFees += fees.getAdmissionFees() + fees.getMonthlyFees()*currentMonth;
		}
		
		if (feesCollection != null) {
			// TODO write code when data exists
		} else {
			monthDue = monthFees;
		}
		
		return monthDue;
	}

	private Integer getTotalDue(List<Fees> feesScale, FeesCollection feesCollection) {
		Integer totalFees = 0, totalDue = 0;
		
		for (Fees fees : feesScale) {
			totalFees += fees.getAdmissionFees() + fees.getMonthlyFees()*12;
		}
		
		if (feesCollection != null) {
			// TODO write code when data exists
		} else {
			totalDue = totalFees;
		}
		
		return totalDue;
	}
	
}

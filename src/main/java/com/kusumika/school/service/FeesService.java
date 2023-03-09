package com.kusumika.school.service;

import org.springframework.stereotype.Service;

import com.kusumika.school.bean.FeesDue;

@Service
public interface FeesService {

	FeesDue getFeesDue(int householdId);
	
}

package com.kusumika.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kusumika.school.bean.FeesDue;
import com.kusumika.school.service.FeesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fees")
@Slf4j
public class FeesController {

	@Autowired
	FeesService feesService;
		
	@GetMapping("/due/{householdId}")
	public FeesDue getFeesDue(@PathVariable int householdId) {
		log.info("Fetching fees due for houlsehold Id {}", householdId);
		return feesService.getFeesDue(householdId);
	}

}

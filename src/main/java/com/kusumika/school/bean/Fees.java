package com.kusumika.school.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fees {

	@JsonProperty("admission_fees")
	int admissionFees;
	
	@JsonProperty("monthly_fees")
	int monthlyFees;
}

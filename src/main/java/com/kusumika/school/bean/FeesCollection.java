package com.kusumika.school.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeesCollection {
	
	@JsonProperty("payment_json")
	String payments;
	
	@JsonProperty("previous_due")
	Integer previousDue;
	
	@JsonProperty("advance_payment")
	Integer advancePayment;
	
	@JsonProperty("concession")
	Integer concession;

}

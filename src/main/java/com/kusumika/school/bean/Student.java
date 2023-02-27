package com.kusumika.school.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {

	@JsonProperty("student_id")
	int studentId;
	
	@JsonProperty("first_name")
	String firstName;
	
	@JsonProperty("middle_name")
	String middleName;
	
	@JsonProperty("last_name")
	String lastName;
	
	@JsonProperty("standard")
	String standard;
	
	@JsonProperty("class_roll")
	short rollNo;
	
	@JsonProperty("date_of_birth")
	Date dob;
	
	@JsonProperty("aadhar")
	String aadhar;
	
	@JsonProperty("bank_ifsc")
	String bankIfsc;
	
	@JsonProperty("bank_account_number")
	String accountNumber;
	
	@JsonProperty("bank_account_holder")
	char accountHolder;
	
	@JsonProperty("household_id")
	int householdId;
	
}

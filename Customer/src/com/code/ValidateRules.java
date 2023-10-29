package com.code;
import com.code.Customer;

import java.time.LocalDate;
import java.util.List;
public class ValidateRules {
	
	
	public static ServicePlan parseAndValidate(String plan) throws InvalidPlan
	{
//		String p1=plan.toUpperCase();
//		String p2=ServicePlan.valueOf(p1);
//		System.out.println("INSIDE PLAN VALIDATE");
		return ServicePlan.valueOf(plan.toUpperCase());
		
	}
	
	public static double parseAndValidatePlanPrice(String Plan,double amount) throws InvalidPlan
	{
//		System.out.println("INSIDE VALIDATE PLAN PRICE");
	ServicePlan plan1=ServicePlan.valueOf(Plan.toUpperCase());
	if(plan1.getPlan()!=amount)
		throw new InvalidPlan("PLAN AND AMOUNT NOT MATCHED");
	return amount;
	}
	
	public static void parseAndValidateEmail(String email,List<Customer>list) throws InvalidPlan
	{
//		System.out.println("INSIDE EMAIL VALIDATE");
		Customer c=new Customer(email);
		if((list.contains(c)))
			throw new InvalidPlan("Email iD already Exists");
	}
	
	
	
	public static Customer validateAllInputs(String fName, String lName, String email, String password, double regAmount,
			String dob, String plan,List<Customer>list) throws InvalidPlan
	{
//		System.out.println("INSIDE VALIDATE ALL INPUTS BEFORE PLAN VALIDATE");
		ServicePlan servicePlan = parseAndValidate(plan);
//		System.out.println("AFTER VALIDATING PLAN");
//		System.out.println("BEFORE VALIDATING PLAN AND PRICE");
		double amt=parseAndValidatePlanPrice(plan,regAmount);
//		System.out.println("AFTER VALIDATING PLAN AND PRICE");
//		System.out.println("BEFORE VALIDATING EMAIL");
		parseAndValidateEmail(email,list);
//		System.out.println("AFTER VALIDATING RESULTS");
		return new Customer( fName,lName,email,password,amt,LocalDate.parse(dob),servicePlan);
		
		
	}
	
	
	

}

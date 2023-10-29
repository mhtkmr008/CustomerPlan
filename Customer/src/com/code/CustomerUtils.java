package com.code;
import com.code.Customer;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.parse;

import java.time.LocalDate;

public class CustomerUtils {
	
	public static boolean FindByMailId(String email,String password,List<Customer>list) throws InvalidPlan
	{
		Customer cust=new Customer(email);
		int index=list.indexOf(cust);
		if (index==-1)
			throw new InvalidPlan("Email ID not found");
		Customer c=list.get(index);
		if(!(c.getPassword().equals(password)))
		throw new InvalidPlan("Password Not matched");
		return true;
}
	
	public static void ChangePassword(String email,String password,String npassword,List<Customer>list) throws InvalidPlan
	{
		Customer c1=new Customer(email);
		int index1=list.indexOf(c1);
		if(index1==-1)
		throw new InvalidPlan("Wrong Email Id");
		if(!((list.get(index1)).getPassword().equals(password)))
		throw new InvalidPlan ("Wrong Password Entered");
		(list.get(index1)).setPassword(npassword);
	}
	
	public static void DeleteUser(String email,String password,List<Customer>list) throws InvalidPlan
	{
		Customer c1=new Customer(email);
		int index2=list.indexOf(c1);
		if(index2==-1)
		throw new InvalidPlan("Wrong Email Id");
		if(!((list.get(index2)).getPassword()==(password)))
		throw new InvalidPlan ("Wrong Password Entered");
		list.remove(index2);
	}
	
	public static List<Customer> populateList()
	{
		List<Customer> list = new ArrayList<>();
		list.add(new Customer("Mohit5","Kumar0","mhtkmr5","123",1000.0,parse("2023-05-25"),ServicePlan.SILVER));
		list.add(new Customer("Mohit0","Kumar1","mhtkmr0","123",5000.0,parse("2023-05-26"),ServicePlan.DIAMOND));
		list.add(new Customer("Mohit4","Kumar2","mhtkmr4","123",1000.0,parse("2023-05-05"),ServicePlan.SILVER));
		list.add(new Customer("Mohit1","Kumar3","mhtkmr1","123",2000.0,parse("2023-05-27"),ServicePlan.GOLD));
		list.add(new Customer("Mohit3","Kumar4","mhtkmr3","123",5000.0,parse("2023-05-29"),ServicePlan.DIAMOND));
		list.add(new Customer("Mohit2","Kumar5","mhtkmr2","123",2000.0,parse("2023-05-30"),ServicePlan.GOLD));
		
		return list;
	}
}

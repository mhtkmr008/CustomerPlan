package com.test;
import com.code.CustomOrderDate;
import static com.code.ValidateRules.*;

import java.util.Comparator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import com.code.ValidateRules;

import com.code.Customer;
import static com.code.CustomerUtils.*;

public class TestCustomer 
	{

	public static void main(String[] args) 
		{
		try(Scanner sc=new Scanner(System.in))
		{
			List<Customer>list = populateList();
			//List<Customer>list=new ArrayList<>();
			boolean choice=false;
			while(!choice)
			{
				System.out.println("SILVER(1000),GOLD(2000),DIAMOND(5000),PLATINUM(10000)");
				System.out.println("1:SignUp 2:SignIn 3:ChangePassword 4:Unsubscride 5:Display 6:Natural Ordring 7:Custom Order Date 0:Exit");
				try {
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Customer Details:first Name,last Name,email,password,amtount,Dob,servicePlan");
					Customer cust=validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),
							sc.next(),sc.next(),list);
					list.add(cust);
					System.out.println("Customer Added");
					break;
				case 2:
					System.out.println("Enter Email and Password");
					FindByMailId(sc.next(),sc.next(),list);
					System.out.println("Email ID and Password Matches");
					break;
				case 3:
					System.out.println("Enter EmailId password and new password");
					ChangePassword(sc.next(),sc.next(),sc.next(),list);
					System.out.println("Password Successfully changed");
					break;
				case 4:
					System.out.println("Enter Emailid,password");
					DeleteUser(sc.next(),sc.next(),list);
					System.out.println("User Removed");
					break;
				case 5:
					System.out.println("The Elements of the array are");
					for(Customer c:list)
						System.out.println(c);
					break;
				case 6:
					Collections.sort(list);
					break;
				case 7:
					Collections.sort(list,new CustomOrderDate());
					break;
				case 8:
					Collections.sort(list,new Comparator<Customer>() {

						@Override
						public int compare(Customer o1, Customer o2) {
							int ret=(o1.getDob()).compareTo(o2.getDob());
							if(ret==0)
							{
								if(o1.getRegAmount()<o2.getRegAmount())
								return -1;
								if(o1.getRegAmount()>o2.getRegAmount())
								return 1;
								return 0;
							}
							return 1;
						}
						
					});
					break;
				case 0:
					choice=true;
					break;
				}
			
				
			}catch(Exception e) {System.out.println(e);}
			}
			
			
		}
		
		}
	}
	
		
			
//		Scanner sc=new Scanner(System.in);
//		List<Customer>list=new ArrayList<>();
//		try{System.out.println("Enter Customer Details:first Name,last Name,email,password,amtount,Dob,servicePlan");
//		System.out.println("AFTER ASKING DETAILS");
//		Customer cust=ValidateRules.validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),
//				sc.next(),sc.next(),list);
//		System.out.println("AFTER ACCEPTING DETAILS");
//		list.add(cust);
//		for(Customer c:list)
//		{
//			System.out.println(c);
//		}
//		}catch(Exception e) {System.out.println(e);}
	/*try() {
				
				List<Customer>list=new ArrayList<>();
				
				
				boolean choice=false;
				while(!choice)
				{
				System.out.println("1:Add Elements");
				switch(sc.next())
				{
				case 1:
					System.out.println("Enter Details ");
					Customer cus=validateAllInputs(sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),sc.next(),sc.next(),list);
					break;
				}
				}
			}catch(Exception e) {System.out.println(e);}
			
		
		
		}
	}*/



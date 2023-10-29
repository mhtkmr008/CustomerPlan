package com.code;
import java.time.LocalDate;
import java.lang.Comparable;
public class Customer implements Comparable <Customer>
{

		private int customerId;
		private String fName;
		private String lName;
		private String email;
		private String password;
		private double regAmount;
		private LocalDate dob;
		private ServicePlan plan ;
		private static int idGenerator;
		
		static
		{
			idGenerator=1;
		}
		
		
		public Customer( String fName, String lName, String email, String password, double regAmount,
				LocalDate dob, ServicePlan plan) 
		{
			super();
			this.customerId = idGenerator++;
			this.fName = fName;
			this.lName = lName;
			this.email = email;
			this.password = password;
			this.regAmount = regAmount;
			this.dob = dob;
			this.plan = plan;
			
		}
		
		public Customer(String email)
		{
			this.email=email;
		}


		@Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", fName=" + fName + ", lName=" + lName + ", email=" + email
					+ ", regAmount=" + regAmount + ", dob=" + dob + ", plan=" + plan + "]";
		}	
		
		
		@Override
		public boolean equals(Object anotherObj)
		{
			if(anotherObj instanceof Customer)
				return this.email.equals(((Customer)anotherObj).email);
			return false;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		

		public double getRegAmount() {
			return regAmount;
		}

		@Override
		public int compareTo(Customer anotherObject) {
			return (this.email).compareTo(anotherObject.email);
			
		}
		
		
		
		

	

}

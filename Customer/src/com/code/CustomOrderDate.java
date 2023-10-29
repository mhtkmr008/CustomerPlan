package com.code;
import java.time.LocalDate;
import java.util.Comparator;

public class CustomOrderDate implements Comparator<Customer>
{
	@Override
	public int compare(Customer o1, Customer o2) {
		return (o1.getDob()).compareTo(o2.getDob());
	}
}

package com.sample;

public class Person {

	private String name;
	private int age;
	
	public String getCategory(int age){
		
		if(age<12)
			return "kid";
		else if(age>12 && age<20)
			return "teen";
		else if(age>19 && age<40)
			return "adult";
		else
			return "old";
		
	}
}

package com.Employee;

import com.Person.Person;

public class Employee extends Person {
	int Sno; String dept;
	
	public Employee(int Sno, String name, int age,String dept)
	{super(name, age);this.Sno=Sno; this.dept=dept;}

	public void Empdisplay(){
		System.out.print(Sno+"\t");
		super.display();
		System.out.println(dept);
	}
}

package com.Inhsuper0825_1;

public class Employee {
	int empNo;
	String eName, dept;
	int pay;
	
	public Employee() {}
	public Employee(int empNo, String eName, String dept,int pay)
	{this.empNo=empNo; this.eName=eName; this.dept=dept;this.pay=pay;}
	
	public void setPay(int pay){this.pay=pay;}
	
	public void display(){
		System.out.print(empNo+"\t");
		System.out.print(eName+"\t");
		System.out.print(dept+"\t");
		System.out.println(pay);
	}
}

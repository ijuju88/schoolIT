package com.AbstractTest;

public class SalseEmp extends Employeetabstract {
	int salary=0,extraPay=0;
	
	
	public SalseEmp(int empno, String name, String dept) 
	{this.empno=empno; this.name=name; this.dept=dept;}

	public void setsalary(int salary){this.salary = salary;}
	public void setextraPay(int extraPay) {this.extraPay = extraPay;}
	@Override
	public void setPay() {pay=salary+extraPay;}
			
	public void display()
	{	super.display();
		System.out.println("급여 : "+pay);}
}

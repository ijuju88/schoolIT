package com.AbstractTest;

public class TemperaryEmp extends Employeetabstract {
	int time, timePay;
	
	public TemperaryEmp(int empno, String name, String dept) 
	{this.empno=empno; this.name=name; this.dept=dept;}
	
	public void settime(int time){this.time=time; }
	public void settimePay(int timePay){this.timePay=timePay;}
	@Override
	public void setPay() {pay=time*timePay;}
	
	public void display(){
		super.display();
		System.out.println("급여 : "+pay);}

}

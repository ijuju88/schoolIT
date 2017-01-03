package com.AbstractTest;

public class RegularEmp extends Employeetabstract {
	int salary=0;
	
	public RegularEmp(int empno, String name, String dept) 
	{this.empno=empno; this.name=name; this.dept=dept;}

	public void setsalarys(int salary) {this.salary = salary;}
	@Override
	public void setPay() {pay+=salary;}
	
	public void display(){
		super.display();
		System.out.println("급여 : "+pay);
	}

}

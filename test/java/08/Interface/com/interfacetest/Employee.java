package com.interfacetest;

public class Employee implements PersonInterface {
	int empno, age, pay; String name, dept;
	
	public Employee(){}
	public Employee(int empno, String name, int age,  String dept,int pay)
	{this.empno = empno;this.age = age;this.pay = pay;this.name = name;this.dept = dept;}
	@Override
	public void setName(String name) {this.name=name;}
	@Override
	public void setAge(int age) {this.age=age;}
	
	public void setEmpno(int empno) {this.empno = empno;}

	public void setPay(int pay) {this.pay = pay;}

	public void setDept(String dept) {this.dept = dept;}

	@Override
	public void dispaly() 
	{System.out.println(empno+":"+name+":"+age+":"+dept+":"+pay);}
	@Override
	public boolean comperTo(PersonInterface per) {
		if(this.pay>((Employee)per).pay)return true;
		else return false;
	}

}

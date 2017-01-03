package com.ClassStary;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new Employee("hong", "영업부",100);
		emp.Inbonus();
		emp.InyearPay();
		emp.display();
	}

}

class Employee{

	String name ,dName;
	int pay, bouns, yearPay;
	
	Employee(String name, String dName,int pay) {
		this.name = name;this.dName = dName;this.pay = pay;}


	//int Inbonus(){bouns=(int) (pay*0.5); return bouns;}
	void Inbonus(){bouns=(int) (pay*0.5);}
	int InyearPay()
	{yearPay=pay*12+bouns; return yearPay;}
	
	
	void display(){
		System.out.println(name+"\t"+dName+"\t"+pay+"\t"+bouns+"\t"+yearPay);
	}
	
	
}
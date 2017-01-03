package com.Inhsuper0825_1;

public class SalseEmployee extends Employee {
	int Salpay=0;
	
	public SalseEmployee() {}
	public SalseEmployee
	(int empNo,String eName,String dept,int pay) 
	{super(empNo, eName, dept, pay);}	
	
	@Override
	public void setPay(int Salpay)
	{
		this.Salpay=Salpay; this.pay+=Salpay;
	}
	
	public void Salsedisplay(){
		super.display();
		System.out.println("보너스 : "+Salpay);
	}
}

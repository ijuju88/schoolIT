package com.Inhsuper0825_1;

public class PartTimeEmployee extends SalseEmployee {
	int time,timepay;
	
	public PartTimeEmployee() {}
	
	public PartTimeEmployee
	(int empNo,String eName,String dept,int pay) 
	{super(empNo, eName, dept,pay);}
	
	public void setPay(int time, int timepay)
	{this.time=time;this.timepay=timepay; this.pay=time*timepay;
	}
	
	public void PartTimedisplay()
	{
		super.display();
		System.out.println("시간 : "+time);
		System.out.println("시급 : "+timepay);
	}
}

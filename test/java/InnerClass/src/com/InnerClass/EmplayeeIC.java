package com.InnerClass;

public class EmplayeeIC {
	int eno, pay;
	String ename;
	Department dept=new Department();
	
	public EmplayeeIC(int eno, String ename, int pay) 
	{this.eno=eno; this.ename=ename; this.pay=pay;}
	

	class Department{
		int dno;
		String dname,line;
		
		public Department(){}
		public Department(int dno, String dname, String line)
		{this.dno=dno; this.dname=dname; this.line=line;}
		
		void display(){
			System.out.println(dno);
			System.out.println(dname);
			System.out.println(line);
		}
	}		
		void setDepartment(int DNo, String DName, String Line){
			Department dp=new Department(DNo, DName, Line);
			dp.display();
		}
		
		void display(){
			System.out.println(eno);
			System.out.println(ename);
			System.out.println(pay);
		}

}

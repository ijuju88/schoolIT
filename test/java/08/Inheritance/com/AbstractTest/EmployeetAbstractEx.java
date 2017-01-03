package com.AbstractTest;

public class EmployeetAbstractEx {

	public static void main(String[] args) {
		int EmpPay = 0;

		Employeetabstract earr[]=new Employeetabstract[3];
		
		RegularEmp re = new RegularEmp(1,"홍길동", "사장");
		re.setsalarys(500);
		earr[0]=re;
		
		SalseEmp sa=new SalseEmp(2,"박사원","사원");
		sa.setsalary(50);
		sa.setextraPay(300);
		earr[1]=sa;
		
		TemperaryEmp te=new TemperaryEmp(3,"김인턴","인턴");
		te.settime(8);
		te.settimePay(5500);
		earr[2]=te;
		
		System.out.println("---배열로 출력하기---");
		for (Employeetabstract em : earr) {
			em.setPay();
			em.display();
		}
		
		System.out.println("");
		System.out.println("---변수의 자동타입변환---");
		
		Employeetabstract ep=null;
		ep=new RegularEmp(1,"홍길동", "사장");
		((RegularEmp) ep).setsalarys(500);
		ep.setPay();
		((RegularEmp) ep).display();
		
		ep=new SalseEmp(2,"박사원","사원");
		((SalseEmp) ep).setsalary(50);
		((SalseEmp) ep).setextraPay(300);
		ep.setPay();
		((SalseEmp) ep).display();
		
		ep=new TemperaryEmp(3,"김인턴","인턴");
		((TemperaryEmp) ep).settime(8);
		((TemperaryEmp) ep).settimePay(5500);
		ep.setPay();
		((TemperaryEmp) ep).display();
		
	

	}
}

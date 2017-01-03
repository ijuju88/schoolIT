package com.Inhsuper0825_1;

public class EmployeeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e=new Employee(1, "홍길동", "부장", 300);
		e.display();
		
		SalseEmployee s=new SalseEmployee(2, "박한진", "사원", 500);
		s.setPay(5000);
		s.Salsedisplay();
		
		PartTimeEmployee p=new PartTimeEmployee(3, "aaa", "계약직", 100);
		p.setPay(8,6000);
		p.PartTimedisplay();
	}

}


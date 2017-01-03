package com.InnerClass;

import com.InnerClass.EmplayeeIC.Department;

public class EmpICMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmplayeeIC eic1=new EmplayeeIC(1, "홍길동", 500);
		eic1.display();
		eic1.setDepartment(1, "관리직", "관리");
	}

}

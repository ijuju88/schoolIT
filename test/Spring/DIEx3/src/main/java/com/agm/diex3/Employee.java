package com.agm.diex3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean{
	private int empno;
	private String name, position;
	private Department dept;
	
	public Employee(int empno, String name) {
		this.empno=empno;
		this.name=name;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("afterPropertiesSet()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("destroy()");
	}
	
}

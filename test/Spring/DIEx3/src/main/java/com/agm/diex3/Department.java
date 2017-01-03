package com.agm.diex3;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class Department implements InitializingBean, DisposableBean{
	private int deptno;
	private String dname;
	
	public Department(int deptno, String dname) {
		this.deptno=deptno;
		this.dname=dname;
	}
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("afterPropertiesSet()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("depdestroy()");
	}
	
	@Bean
	@Scope("prototype")
	Department customerService(){
	return new Department(deptno, dname);
	}
}

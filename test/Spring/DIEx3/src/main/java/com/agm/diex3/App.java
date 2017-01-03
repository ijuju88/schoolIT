package com.agm.diex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx=new FileSystemXmlApplicationContext("appCtxBean.xml");
		
		//ctx.getBean("")->xml에서 지정한 name or id 
		Employee emp=ctx.getBean("emp", Employee.class);
		System.out.println(emp.getEmpno());
		System.out.println(emp.getName());
		System.out.println(emp.getPosition());
		System.out.println(emp.getDept().getDeptno());
		System.out.println(emp.getDept().getDname());
		
		System.out.println("---------------------");
		Department dep1=ctx.getBean("dep", Department.class);
		Department dep2=ctx.getBean("dep", Department.class);
		System.out.println(dep1.customerService());
		System.out.println(dep2.customerService());
	}

}

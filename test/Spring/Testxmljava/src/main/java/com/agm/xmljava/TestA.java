package com.agm.xmljava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TestA {
	private TestB b;
	private TestC c;
	
	@Autowired
	public void setB(TestB b){
		this.b=b;
	}
	
	@Autowired
	public void setC(TestC c){
		this.c=c;
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx=new FileSystemXmlApplicationContext("TEstBean.xml");
		TestA bean=(TestA) ctx.getBean("testa");
		bean.b.display();
		bean.c.display();
	}
	
}

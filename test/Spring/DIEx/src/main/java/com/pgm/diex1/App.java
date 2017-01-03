package com.pgm.diex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args){
		
//		MessageFactory mf=MessageFactory.getInstance();
//		
//		Ibean bean=mf.createMessage("kr");
//		bean.sayHello("김철수");
		
		ApplicationContext ctx=new AnnotationConfigApplicationContext(ApplicationContextConfiguration.class);
		Ibean bean=ctx.getBean("msgBean", Ibean.class); 
		bean.sayHello("홍길동");
	}
}

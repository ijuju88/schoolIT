package com.agm.diex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx=new FileSystemXmlApplicationContext("bean_config1.xml"); 
		
									
		MessageBean bean=ctx.getBean("msgBean", MessageBean.class); 
		bean.sayHello("홍길동");
	}

}

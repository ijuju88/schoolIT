package com.agm.student2;

import java.util.ArrayList;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
	public static void main(String[] args) {
	
		//컨테이너 생성 
		ApplicationContext ctx =new FileSystemXmlApplicationContext("classpath:config.xml");
		
		//컨테이너 설정
		
		//컨테이너 사용
		Student stu=ctx.getBean("stu", Student.class);
		
		System.out.println(stu.toString());
		
		System.out.println(stu.getDept());
		
		ArrayList<String> hobby=stu.getHobby();
		
		for (String h : hobby) {
			System.out.println(h);
		}
		
		//컨테이너 종료
		//ctx.close();
	}
}

package com.agm.student2;

import java.util.ArrayList;

import org.springframework.context.annotation.*;

@Configuration
public class Appconfig {
	@Bean(name="stu")
	public Student student2(){
		ArrayList<String> hobbys=new ArrayList<String>();
		hobbys.add("수영");
		hobbys.add("등산");
		hobbys.add("게임");
		
		Student stu=new Student(1,"홍길동");
		stu.setDept("2학년");
		stu.setHobby(hobbys);
		return stu;
		
	}
}

package com.Inheritance;

import com.Inher.Employee;

class Student extends Person{
	int sno;
	String dept;
	
	void stdDisplay(){
		//부모클래스에 있던 변수를 사용할수 있음
		System.out.print(name+"\t");
		System.out.print(age+"\t");
		System.out.print(sno+"\t");
		System.out.println(dept);
	}
}


public class InherTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1=new Person();
		p1.name="홍길동";
		p1.age=20;
		p1.display();
		
		//상속되서 부모클래스의 메소드, 변수 사용가능 
		Student s1=new Student();
		s1.name="kk";
		s1.age=25;
		s1.sno=1;
		s1.dept="컴";
		s1.stdDisplay();
		
		Employee e1=new Employee();
		e1.name="aaa";
		e1.age=23;
		e1.empNo=1;
		e1.job="영업직";
		e1.empDisplay();
	}

}

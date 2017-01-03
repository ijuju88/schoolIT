package com.Classt;

public class SingleToneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Student s1=new Student(); //외부에서 객체를 만들수가 없어욧!
		Student s2=Student.getInstance(); //getInstance메소드를 호출하여 생성해야됨 ㅠㅠ
		System.out.println(s2.name+", "+s2.sno);

	}

}


class Student{
	String name; int sno;
	private static Student student= new Student();
	
	static Student getInstance(){return student;}
	
	private Student(){name="홍길동"; sno=1;}
	
}
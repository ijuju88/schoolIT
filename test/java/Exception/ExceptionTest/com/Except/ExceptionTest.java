package com.Except;


public class ExceptionTest {

	public static void main(String[] args) {
		
		//java.lang.NullPointerException(객체 참조x)
		/*
		String data=null;   
		System.out.println(data.toString());
		
		//예외처리확인용으로 객체생성을 하지 않고 해봅시당!!  
		Person p=null;  
		//Person p=new Person(); 예외생기지 않게 하려면 객체를 생성하시면 됩니당 
		p.display();
		*/
		
		
		//java.lang.ArrayIndexOutOfBoundsException(배열의 인덱스 범위 초과)
		/*
		int[] data1=new int[3];  
		data1[3]=1; //3크기에 int형 배열을 생성했는데...범위를 초과해서
		 */
		
		
		// java.lang.NumberFormatException
		/*
		String date1="100";
		String date2="a100";
		
		int value1=Integer.parseInt(date1); //interger로 형변환했음..
		int value2=Integer.parseInt(date2); //이건 문자형이라 integer로 형변환을 하시면 --;
		*/
		
		
		//java.lang.ClassCastException
		Person ps=new Person();
		
		Student s=(Student)ps;
		Employee e=(Employee)ps;
	}

}


class Person{
	String name; 
	int age;
	
	void display(){System.out.print(name+"\t"+age);}
}

class Student extends Person{
	String major;
	
	void display(){System.out.println("\t"+major);}
}

class Employee extends Person{
	String job;
	
	void display(){System.out.println("\t"+job);}
	
}
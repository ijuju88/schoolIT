package com.test1;


public class Test {
/*public-외부불려오기 가능함 
 * public class는 1개만 가능함.
 * */
	
	public static void main(String[] arge){
	//main은 public class 클래스 안에서만 사용가능함.
	//void main함수 실행하고 끝~~ *돌려주는 값이 있는경우 리턴시켜줘야함
	//String[] - []은 배열		

		Person p= new Person();// class Person 불려오기(메모리 잡힘)
		p.show(); //불려오고 접근
		
		Person.display(); // static함수이므로 바로 접근
		//Preson.show(); (x) static 함수가 없으면 그냥 접근안됨
		
	}
	
}


class Person{
	
	int age=20; //변수 선언과 동시 값넣기
	String name="홍길동";
	static String job="회사원"; //static 
	
	
	public void show(){
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
	}
	
	public static void display(){
		System.out.println("직업 : "+job); 
	}
}
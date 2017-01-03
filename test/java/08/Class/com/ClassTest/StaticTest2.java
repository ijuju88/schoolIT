package com.ClassTest;

public class StaticTest2 {
	public static void main(String[] args) {
		Empoyee emp1=new Empoyee("홍길동","영업",200);
		emp1.display();
		
		Empoyee emp2=new Empoyee("홍길자","생산",300);
		emp2.display();
		
		Empoyee emp3=new Empoyee("홍길숙","기획",250);
		emp3.display();
		
		Empoyee emp4=new Empoyee("홍길미","홍보",220);
		emp4.display();
	}
}

class Empoyee{
	String name,dept;
	int pay;
	
	static int cnt;
	//int cnt;  //만들때마다 새로 되므로 결과가 1로 나옴
	
	Empoyee(){}

	Empoyee(String name, String dept, int pay) 
	{this.name = name;this.dept = dept;this.pay = pay;cnt++;}
	
	void display(){
		System.out.print(name+" ");
		System.out.print(dept+" ");
		System.out.print(pay+" ");
		System.out.println(cnt);
	}
	
}
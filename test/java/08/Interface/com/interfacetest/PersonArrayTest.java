package com.interfacetest;

public class PersonArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonInterface[] pi=new PersonInterface[3];
		pi[0]=new Student("aa", 20, "영문", 85);
		pi[1]=new Student("bb", 22, "컴공", 75);
		pi[2]=new Employee(1,"cc", 30, "기획", 500);
		
		for (PersonInterface per : pi) {
			per.dispaly();
		}
		
		PersonInterface[] pi2={
				new Student("aa", 20, "영문", 85),
				new Student("bb", 22, "컴공", 75),
				new Employee(1,"cc", 30, "기획", 500)
		};
		
		System.out.println(pi2[0].comperTo(pi2[1]));
		
		
		
		
		Student s=new Student("aa", 20, "영문", 85);
		print(s);
		System.out.println(s instanceof PersonInterface);
		for (PersonInterface per : pi2) {
			per.dispaly();
		}
		
		
	}
	static void print(PersonInterface p){p.dispaly();}
	
}

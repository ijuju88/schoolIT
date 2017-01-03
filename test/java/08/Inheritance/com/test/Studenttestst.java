package com.test;

public class Studenttestst {
	public static void main(String[] arge){
	/*	Person1[] per=new Person1[3];
		per[0]=new Person1("kim",20,"부산");
		per[1]=new Student1("Lee",25,"서울","내대학","영문",123);
		per[2]=new Employee1("hong",30,"대전","삼성","기획",500);
		
		for (Person1 p : per) {
			p.display();
		}
		
		print(per);
		
		
		
	}
	
	static void print(Person1[] per)
	{
		for (Person1 p : per) {
			p.display();
		}
	}*/
	
		Student1 s1=new Student1("Lee",25,"서울","내대학","영문",123); printOne(s1);
		Employee1 emp=new Employee1("hong",30,"대전","삼성","기획",500); printOne(emp);
	}		
	static void printOne(Person1 per)
	{
		per.display();
	}
}

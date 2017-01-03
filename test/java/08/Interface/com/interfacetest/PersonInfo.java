package com.interfacetest;

public class PersonInfo {
	public static void main(String[] args){
		Student st=new Student();
		st.setName("홍길동");
		st.setAge(20);
		st.setMajor("컴공");
		st.setScore(60);
		
		Myclass myclass=new Myclass(st);
		
		Employee em=new Employee();
		em.setEmpno(1);
		em.setName("박사장");
		em.setAge(30);
		em.setDept("사장");
		em.setPay(500);
		
		myclass=new Myclass(em);
		
		myclass.MethodA(st);
		myclass.MethodB();
		
		st.defMethod();
		em.defMethod();
		
		PersonInterface.stataicMethod();
	}
}

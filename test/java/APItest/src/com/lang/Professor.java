package com.lang;

public class Professor {
	int pno;
	String name, major, subject;
	
	public Professor(int pno, String name, String major, String subject) {
		super(); //Object를 의미합니당~~ 없어도 됩니당
		this.pno = pno;
		this.name = name;
		this.major = major;
		this.subject = subject;
	}
	
	public boolean equals(Object obj){
		Professor pf=(Professor)obj;
		if(this.pno==pf.pno){return true;}
		else return false;
	}
	

	public static void main(String[] args){
		Professor p1=new Professor(1, "Lee", "컴공", "영어");

		Professor p2=new Professor(2, "kim", "멀티", "컴터");
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p2.toString());
		System.out.println(p1.getClass());
		
	}
}

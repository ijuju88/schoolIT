package com.InnerClass;

public class StubjectInnerClass {
	int sno;
	String name, major;
	
	
	StubjectInnerClass(int sno, String name, String major) 
	{this.sno = sno; this.name = name; this.major = major;}

	class Score{
		String subject, professor;
		int point;
		
		
		public Score(String subject, String professor, int point) 
		{this.subject=subject; this.professor=professor; this.point=point;}

		void display()
		{System.out.println(subject);
		System.out.println(professor);
		System.out.println(point);
		}
	}
	
	void setScore(String subj, String pro, int point)
	{
		Score score=new Score(subj, pro, point);
		score.display();
	}
	
	void display(){
		System.out.println(sno);
		System.out.println(name);
		System.out.println(major);
	}
	
}
